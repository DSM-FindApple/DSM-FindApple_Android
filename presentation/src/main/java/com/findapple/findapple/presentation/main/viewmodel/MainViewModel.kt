package com.findapple.findapple.presentation.main.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase
import com.findapple.findapple.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MainViewModel(private val checkLoginUseCase: CheckLoginUseCase) : BaseViewModel() {
    val location = MutableLiveData(Location(127.3635946, 36.3914388))

    private val _hasLogin = MutableLiveData<Boolean>()
    val hasLogin: LiveData<Boolean> get() = _hasLogin
    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                checkLogin()
            }
        }
    }

    private fun checkLogin() {
        checkLoginUseCase.execute(
            Unit, object : DisposableSingleObserver<Boolean>() {
                override fun onSuccess(t: Boolean) {
                    _hasLogin.value = t
                }

                override fun onError(e: Throwable) {
                    _hasLogin.value = false
                }

            },
            AndroidSchedulers.mainThread()
        )
    }
}