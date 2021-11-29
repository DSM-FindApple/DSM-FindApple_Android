package com.findapple.findapple.app.bindingadapter

import android.graphics.PorterDuff
import android.util.Log
import android.webkit.*
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.findapple.findapple.R
import com.findapple.findapple.app.adapter.MultipleRecyclerViewAdapter
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

@BindingAdapter("recyclerItemsHorizontalItems")
fun RecyclerView.setHorizontalList(list: List<RecyclerViewItem>?) {
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        layoutManager = LinearLayoutManager(context).apply {
            orientation = RecyclerView.HORIZONTAL
        }
    }

    if (list != null) {
        (adapter as? RecyclerViewAdapter)?.updateData(list)
    }
}

@BindingAdapter("multipleRecyclerItems")
fun RecyclerView.setMultipleList(list: List<MultipleRecyclerViewItem>?) {
    if (adapter == null) {
        adapter = MultipleRecyclerViewAdapter()
        layoutManager = LinearLayoutManager(context)
    }

    if (list != null) {
        (adapter as? MultipleRecyclerViewAdapter)?.updateData(list)
    }
}

@BindingAdapter("viewPagerItems")
fun ViewPager2.setList(list: List<RecyclerViewItem>?) {
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    if (list != null) {
        (adapter as? RecyclerViewAdapter)?.updateData(list)
    }
}

@BindingAdapter("setWebView")
fun WebView.setWebView(url: String?) {
    this.run {
        if (url != null) {
            settings.run {
                javaScriptEnabled = true
                builtInZoomControls = false
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
            }
            loadUrl(url)
        }
    }

}

@BindingAdapter("imageUrl")
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

@BindingAdapter("serverImageUrl")
fun ImageView.loadServerImage(resource: String?) {
    val progressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        setColorFilter(ContextCompat.getColor(context, R.color.blue_500), PorterDuff.Mode.SRC_IN)
        start()
    }

    Glide.with(context)
        .load("http://3.35.221.104:8080/image/$resource")
        .placeholder(progressDrawable)
        .error(R.drawable.ic_fineapple_main)
        .into(this)
}

@BindingAdapter("intText")
fun TextView.toIntText(int: Int) {
    text = int.toString()
}