package com.findapple.findapple.app.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(), LifeCycleCallback {
    val needLogin = SingleLiveEvent<Unit>()

    fun startLogin() {
        needLogin.call()
    }
}