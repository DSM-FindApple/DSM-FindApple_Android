package com.findapple.findapple.presentation.features.chat

import android.webkit.JavascriptInterface
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModel

class ChatWebBridge(private val chattingFragment: ChattingFragment) {

    @JavascriptInterface
    fun startChatDetail(id: String) {
        chattingFragment.moveToChattingDetail(id)
    }
}