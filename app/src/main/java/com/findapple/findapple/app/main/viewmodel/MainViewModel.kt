package com.findapple.findapple.app.main.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase
import com.findapple.findapple.domain.main.usecase.RefreshTokenUseCase
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MainViewModel(private val checkLoginUseCase: CheckLoginUseCase, private val refreshTokenUseCase: RefreshTokenUseCase) : BaseViewModel() {
    val location = MutableLiveData<Location>()

    private val _hasLogin = MutableLiveData<Boolean>()
    val hasLogin: LiveData<Boolean> get() = _hasLogin

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> get() = _token

    val message = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                checkLogin()
            }
        }
    }

    private fun checkLogin() {
        checkLoginUseCase.execute(
            Unit, object : DisposableSingleObserver<String>() {
                override fun onSuccess(t: String) {
                    _token.value = t
                    _hasLogin.value = t.isNotBlank()
                    if(hasLogin.value == true) {
                        refreshToken()
                    }
                }

                override fun onError(e: Throwable) {
                    _hasLogin.value = false
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun refreshToken() {
        refreshTokenUseCase.execute(
            Unit,
            object : DisposableSingleObserver<Result<Token>>() {
                override fun onSuccess(t: Result<Token>) {
                    if(t is Result.Failure) {
                        message.value = "로그인이 필요합니다"
                        needLogin.call()
                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }
}