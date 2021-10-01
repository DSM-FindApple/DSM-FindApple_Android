package com.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.domain.base.Result
import com.findapple.domain.features.mypage.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(private val getUserUseCase: GetUserUseCase) : BaseViewModel() {

    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

    fun getUserInfo() {
        getUserUseCase.execute(
            data = Unit,
            singleObserver = object : DisposableSingleObserver<Result<User>>() {
                override fun onSuccess(t: Result<User>) {
                    when (t) {
                        is Result.Success -> {
                            _userProfile.value = t.value
                        }
                        is Result.Failure -> {

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