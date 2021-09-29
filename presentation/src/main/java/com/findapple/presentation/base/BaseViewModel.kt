package com.findapple.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    val needLogin = SingleLiveEvent<Unit>()

    fun startLogin(){
        needLogin.call()
    }
}