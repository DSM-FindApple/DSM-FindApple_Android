package com.findapple.presentation.bindingadapter

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("setWebView")
fun WebView.setWebView(url: String) {
    this.run {
        settings.run {
            javaScriptEnabled = true
            builtInZoomControls = false
        }
        loadUrl(url)
    }
}

