package com.findapple.findapple.app.features.chat

import android.webkit.JavascriptInterface

class ChatWebBridge(private val chattingFragment: ChattingFragment) {

    @JavascriptInterface
    fun startChatDetail(id: String) {
        chattingFragment.moveToChattingDetail(id)
    }
}