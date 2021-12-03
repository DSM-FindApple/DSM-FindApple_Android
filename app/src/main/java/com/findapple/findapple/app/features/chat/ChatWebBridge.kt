package com.findapple.findapple.app.features.chat

import android.webkit.JavascriptInterface
import androidx.fragment.app.Fragment
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment

class ChatWebBridge(private val fragment: Fragment) {

    @JavascriptInterface
    fun startChatDetail(
        id: String,
        isBan: Boolean,
        title: String,
        topMessage: String,
        targetId: Long
    ) {
        (fragment as ChattingFragment).moveToChattingDetail(id, isBan, title, topMessage, targetId)
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

    fun sendToken(token: String) {
        val webView = (fragment as ChattingFragment).binding.chatWv
        webView.loadUrl("javascript:sendToken(`$token`)")
    }

}