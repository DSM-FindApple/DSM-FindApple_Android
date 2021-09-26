package com.findapple.presentation.features.mypage.viewmodel

import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.domain.base.Result
import com.findapple.domain.errorhandler.Error
import com.findapple.domain.features.mypage.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(private val getUserUseCase: GetUserUseCase) : BaseViewModel() {

    fun getUserInfo() {
        getUserUseCase.execute(
            data = Unit,
            singleObserver = object : DisposableSingleObserver<Result<User>>() {
                override fun onSuccess(t: Result<User>) {
                    when (t) {
                        is Result.Success -> {

                        }
                        is Result.Failure -> {
                            needLogin.call()
                            if (t.reason == Error.UnAuthorized) {
                                needLogin.call()
                            }
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            },
            AndroidSchedulers.mainThread()
        )
    }
}