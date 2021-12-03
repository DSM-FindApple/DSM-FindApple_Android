package com.findapple.findapple.app.features.lost

import android.webkit.JavascriptInterface
import androidx.fragment.app.Fragment

class LostWebBridge(private val fragment: Fragment) {

    @JavascriptInterface
    fun startSearch(type: String) {
        (fragment as LostFragment).moveToSearch(type)
    }
}