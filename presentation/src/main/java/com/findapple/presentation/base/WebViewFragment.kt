package com.findapple.presentation.base

import android.webkit.WebView
import androidx.databinding.ViewDataBinding

abstract class WebViewFragment<T : ViewDataBinding>(resId: Int) : BaseFragment<T>(resId) {

    abstract val webViewUrl: String
    fun setWebView(webView: WebView) {
        webView.run {
            settings.run {
                javaScriptEnabled = true
                builtInZoomControls = false
            }
            loadUrl(webViewUrl)
        }
    }
}