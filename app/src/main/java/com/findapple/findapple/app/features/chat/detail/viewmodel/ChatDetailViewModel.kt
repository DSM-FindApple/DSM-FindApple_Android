package com.findapple.findapple.app.features.chat.detail.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.app.base.BaseViewModel

class ChatDetailViewModel: BaseViewModel() {
    val selectedDateTime = MutableLiveData<String>()
    override fun apply(event: Lifecycle.Event) {
    }
}