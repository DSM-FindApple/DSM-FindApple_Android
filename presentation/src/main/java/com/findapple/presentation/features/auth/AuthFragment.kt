package com.findapple.presentation.features.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentAuthBinding
import com.findapple.presentation.features.auth.viewmodel.AuthViewModel
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthFragment : BaseFragment<FragmentAuthBinding>(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory

    override val viewModel: AuthViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            authLoginBtn.setOnClickListener {
                startKakaoLogin()
            }
            authLoginVp.adapter = AuthAdapter()
            TabLayoutMediator(authLoginTl, authLoginVp) { _, _ ->
            }.attach()
        }
    }

    private fun getUserInfo() {
        UserApiClient.instance.me { user, _ ->
            if (user != null) {
                viewModel.login(
                    user.id,
                    user.kakaoAccount?.profile?.nickname.toString(),
                    user.kakaoAccount?.profile?.profileImageUrl.toString()
                )
            }
        }
    }

    override fun observeEvent() {
        viewModel.run {
            doneLogin.observe(viewLifecycleOwner, {
                onBackPressed()
            })
            errorMessage.observe(viewLifecycleOwner, {
                snackBarComment(it)
            })
        }
    }

    private lateinit var kakaoLoginDisposable: DisposableSingleObserver<OAuthToken>

    private fun startKakaoLogin() {
        kakaoLoginDisposable =
            object : DisposableSingleObserver<OAuthToken>() {
                override fun onSuccess(t: OAuthToken) {
                    getUserInfo()
                }

                override fun onError(e: Throwable) {
                    snackBarComment("카카오로그인에 실패했습니다")
                }
            }
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
            UserApiClient.rx.loginWithKakaoTalk(requireContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(kakaoLoginDisposable)
        } else {
            UserApiClient.rx.loginWithKakaoAccount(requireContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(kakaoLoginDisposable)
        }
    }

}