package com.findapple.presentation.features.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.findapple.presentation.R
import com.findapple.presentation.base.BackPressFinishFragment
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.databinding.FragmentAuthBinding
import com.findapple.presentation.features.auth.viewmodel.AuthViewModel
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class AuthFragment : BaseFragment<FragmentAuthBinding>(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory

    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authLoginBtn.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())){
                UserApiClient.rx.loginWithKakaoTalk(requireContext())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({

                    }, {

                    })
                    .addTo(compositeDisposable)
            }else{
                UserApiClient.instance.loginWithKakaoAccount(requireContext()) { token, error ->

                }
            }

        }
    }

    override fun observeEvent() {
    }

}