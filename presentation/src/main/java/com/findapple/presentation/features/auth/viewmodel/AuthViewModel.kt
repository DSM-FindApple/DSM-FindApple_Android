package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.Lifecycle
import com.findapple.domain.base.Result
import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class AuthViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
    }

    fun login(id: String, nickname: String) {
        loginUseCase.execute(
            Auth(id, nickname),
            object : DisposableSingleObserver<Result<Token>>() {
                override fun onSuccess(t: Result<Token>) {
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

}