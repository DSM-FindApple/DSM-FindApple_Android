package com.findapple.findapple.presentation.features.post.bindingadapter

import android.net.Uri
import android.widget.NumberPicker
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.findapple.findapple.presentation.features.post.adapter.PostPhotoAdapter
import com.findapple.findapple.presentation.features.post.viewModel.PostViewModel
import java.time.LocalDate

@BindingAdapter("setPostPhotoItems", "itemsViewModel")
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

@BindingAdapter("setMaxValue")
fun NumberPicker.setNumberPicker(
    max: Int
) {
    wrapSelectorWheel = false

    val now = LocalDate.now()
    when (max) {
        0 -> {
            now.year.run {
                maxValue = this
                minValue = this - 1
                value = this
            }
        }

        12 -> {
            now.month.value.run {
                minValue = 1
                maxValue = max
                value = this
            }
        }

        31 -> {
            now.dayOfMonth.run {
                minValue = 1
                maxValue = max
                value = this
            }
        }
    }
}