package com.findapple.presentation.features.post.bindingadapter

import android.net.Uri
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.features.post.adapter.PostPhotoAdapter
import com.findapple.presentation.features.post.viewModel.PostViewModel

@BindingAdapter("setPostPhotoItems", "viewModel")
fun ViewPager2.setPostPhotoItems(
    images: List<Uri>?,
    viewModel: PostViewModel
) {
    if (adapter == null) {
        adapter = PostPhotoAdapter(viewModel)
    }
    if (images != null) {
        (adapter as? PostPhotoAdapter)?.updateData(images)
    }
}