package com.findapple.findapple.app.features.chat

import android.webkit.JavascriptInterface
import androidx.fragment.app.Fragment

class ChatWebBridge(private val fragment: Fragment) {

    @JavascriptInterface
    fun startChatDetail(id: String) {
        (fragment as ChattingFragment).moveToChattingDetail(id)
    }

    @JavascriptInterface
    fun startSelectDate() {
        (fragment as ChatDetailFragment).showDatePickerDialog()
    }
}