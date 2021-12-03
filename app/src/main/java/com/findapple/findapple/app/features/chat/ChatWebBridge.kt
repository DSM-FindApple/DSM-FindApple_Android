package com.findapple.findapple.app.features.chat

import android.webkit.JavascriptInterface
import androidx.fragment.app.Fragment
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment

class ChatWebBridge(private val fragment: Fragment) {

    @JavascriptInterface
    fun startChatDetail(id: String) {
        (fragment as ChattingFragment).moveToChattingDetail(id)
    }

    @JavascriptInterface
    fun startSelectDate() {
        (fragment as ChatDetailFragment).showDatePickerDialog()
    }

    @JavascriptInterface
    fun startGetImage() {
        (fragment as ChatDetailFragment).sendImage()
    }

    @JavascriptInterface
    fun exitChatDetail() {
        (fragment as ChatDetailFragment).onBackPressed()
    }

}