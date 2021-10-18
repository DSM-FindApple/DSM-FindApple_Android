package com.findapple.presentation.base

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("webViewUrl")
fun WebView.setUrl(url: String){
    settings.run {
        setSupportZoom(false)
        useWideViewPort = true
    }
    loadUrl(url)
}