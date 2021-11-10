package com.findapple.findapple.presentation.features.post.bindingadapter

import android.net.Uri
import android.widget.NumberPicker
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.findapple.findapple.presentation.features.post.adapter.PostPhotoAdapter
import com.findapple.findapple.presentation.features.post.viewModel.PostViewModel
import java.time.LocalDateTime

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

@BindingAdapter("setMaxValue", "viewModel")
fun NumberPicker.setNumberPicker(
    max: Int,
    viewModel: PostViewModel
) {

    val nowDate = LocalDateTime.now()
    when (max) {
        0 -> { // year
            nowDate.year.run {
                maxValue = this
                minValue = this - 1
                viewModel.year.value = this
            }
        }

        12 -> { // month
            nowDate.month.value.run {
                minValue = 1
                maxValue = max
                viewModel.month.value = this
            }
        }

        31 -> { // day
            nowDate.dayOfMonth.run {
                minValue = 1
                maxValue = max
                viewModel.day.value = this
            }
        }

        23 -> { // hour
            nowDate.hour.run {
                minValue = 0
                maxValue = max
                viewModel.hour.value = this
            }
        }

        59 -> { // minute
            nowDate.minute.run {
                minValue = 0
                maxValue = max
                viewModel.minute.value = this
            }
        }
    }
}