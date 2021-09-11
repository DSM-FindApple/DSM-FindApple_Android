package com.findapple.findapple.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    val needLogin = SingleLiveEvent<Unit>()
}