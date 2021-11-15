package com.findapple.findapple.app.features.chat.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.app.base.BaseViewModel

class ChattingViewModel : BaseViewModel() {
    val clickedChatId = MutableLiveData<String>()
    override fun apply(event: Lifecycle.Event) {

    }
}