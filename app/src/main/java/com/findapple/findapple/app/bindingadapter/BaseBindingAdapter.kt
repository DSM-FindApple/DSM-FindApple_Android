package com.findapple.findapple.app.bindingadapter

import android.graphics.PorterDuff
import android.webkit.WebView
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.findapple.findapple.R
import com.findapple.findapple.app.adapter.RecyclerViewAdapter

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
fun WebView.setWebView(url: String?) {
    this.run {
        if(url != null) {
            settings.run {
                javaScriptEnabled = true
                builtInZoomControls = false
                loadWithOverviewMode = true
                useWideViewPort = true
            }
            loadUrl(url)
        }
    }
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(resource: String?) {
    val progressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        setColorFilter(ContextCompat.getColor(context, R.color.blue_500), PorterDuff.Mode.SRC_IN)
        start()
    }

    Glide.with(context)
        .load(resource)
        .placeholder(progressDrawable)
        .error(R.drawable.ic_fineapple_main)
        .into(this)
}