package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import com.findapple.domain.base.Result
import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class AuthViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
    }

    private val _doneLogin = SingleLiveEvent<Unit>()
    val doneLogin: LiveData<Unit> get() = _doneLogin

    fun login(id: String, nickname: String) {
        loginUseCase.execute(
            Auth(id, nickname),
            object : DisposableSingleObserver<Result<Token>>() {
                override fun onSuccess(t: Result<Token>) {
                    when (t) {
                        is Result.Success -> {
                            _doneLogin.call()
                        }
                        is Result.Failure -> {
                            onLoginError(t)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun onLoginError(result: Result.Failure<Token>) {

    }

}