package com.findapple.findapple.presentation.features.chat

import android.util.Log
import android.webkit.JavascriptInterface

class ChatWebBridge {
    @JavascriptInterface
    fun startChatDetail(id: String) {
        Log.d("webviewbridge", "id: $id")
    }
}