package com.findapple.presentation.features.post.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.features.post.model.Category

class PostViewModel(private val postFindUseCase: PostFindUseCase) : BaseViewModel() {

    val clickedCategoryIndex = MutableLiveData<Int>()


    override fun apply(event: Lifecycle.Event) {

    }

    fun categoryClicked(position: Int) {
        clickedCategoryIndex.value.run {
            if (this != position) {
                clickedCategoryIndex.value = position
            } else {
                clickedCategoryIndex.value = null
            }
        }

    }
}