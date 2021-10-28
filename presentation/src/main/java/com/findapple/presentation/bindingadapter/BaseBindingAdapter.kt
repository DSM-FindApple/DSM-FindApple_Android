package com.findapple.presentation.bindingadapter

import android.webkit.WebView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.findapple.presentation.adapter.RecyclerViewAdapter

@BindingAdapter("recyclerItems")
fun RecyclerView.setList(list: List<RecyclerViewItem>?) {
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        layoutManager = LinearLayoutManager(context)
    }

    if (list != null) {
        (adapter as? RecyclerViewAdapter)?.updateData(list)
    }
}

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

