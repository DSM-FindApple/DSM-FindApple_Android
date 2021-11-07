package com.findapple.findapple.presentation.features.chat.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.presentation.base.BaseViewModel

class ChattingViewModel : BaseViewModel() {
    val clickedChatId = MutableLiveData<String>()
    override fun apply(event: Lifecycle.Event) {

    }
}