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
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class AuthFragment : BaseFragment<FragmentAuthBinding>(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory

    override val viewModel: AuthViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val afterLogin: DisposableSingleObserver<OAuthToken> =
            object : DisposableSingleObserver<OAuthToken>() {
                override fun onSuccess(t: OAuthToken) {
                    getUserInfo()
                }

                override fun onError(e: Throwable) {

                }

            }
        binding.run {
            authLoginBtn.setOnClickListener {
                if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
                    UserApiClient.rx.loginWithKakaoTalk(requireContext())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(afterLogin)
                } else {
                    UserApiClient.rx.loginWithKakaoAccount(requireContext())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(afterLogin)
                }

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
        viewModel.doneLogin.observe(viewLifecycleOwner, {
            onBackPressed()
        })
    }

}