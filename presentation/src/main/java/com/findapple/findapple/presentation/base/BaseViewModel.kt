package com.findapple.findapple.presentation.base

import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    val needLogin = SingleLiveEvent<Unit>()
}