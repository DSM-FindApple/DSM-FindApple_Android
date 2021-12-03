package com.findapple.findapple.app.features.search

import android.webkit.JavascriptInterface

class SearchWebBridge(private val fragment: SearchFragment) {
    @JavascriptInterface
    fun back() {
        fragment.onBackPressed()
    }
}