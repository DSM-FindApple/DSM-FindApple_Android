package com.findapple.presentation.features.post

import android.net.Uri
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2

@BindingAdapter("setPostPhotoItems")
fun ViewPager2.setPostPhotoItems(
    images: List<Uri>?
) {
    if (adapter == null) {
        adapter = PostPhotoAdapter()
    }
    if (images != null) {
        (adapter as? PostPhotoAdapter)?.updateData(images)
    }
}