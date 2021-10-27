package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import com.findapple.domain.base.Result
import com.findapple.domain.entity.Location
import com.findapple.domain.entity.User
import com.findapple.domain.errorhandler.Error
import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.features.auth.parameter.LoginParameter
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
    }

    private val _doneLogin = SingleLiveEvent<Unit>()
    val doneLogin: LiveData<Unit> get() = _doneLogin

    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun login(id: Long, nickname: String, profileImageUrl: String, location: Location?) {
        val auth = Auth(id, nickname)
        loginUseCase.execute(
            LoginParameter(
                auth,
                location ?: Location(127.3635946, 36.3914388)
            ),
            object : DisposableSingleObserver<Result<Token>>() {
                override fun onSuccess(t: Result<Token>) {
                    when (t) {
                        is Result.Success -> {
                            _doneLogin.call()
                            saveUserInfo(User(id, nickname, profileImageUrl))
                        }
                        is Result.Failure -> {
                            doOnError(t)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun doOnError(result: Result.Failure<Token>) {
        when (result.reason) {
            Error.Network -> {
                _errorMessage.value = "인터넷 연결상태를 확인해주세요"
            }
            Error.InternalServer -> {
                _errorMessage.value = "서버사용량이 많습니다"
            }
            else -> _errorMessage.value = "알수없는 오류가 발생했습니다"
        }
    }

    private fun saveUserInfo(user: User) {
        saveUserUseCase.execute(
            user,
            object : DisposableSingleObserver<Unit>() {
                override fun onSuccess(t: Unit) {
                }

                override fun onError(e: Throwable) {
                }
            },
            AndroidSchedulers.mainThread()
        )
    }

}