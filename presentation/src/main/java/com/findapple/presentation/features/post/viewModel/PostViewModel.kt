package com.findapple.presentation.features.post.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.presentation.base.BaseViewModel

class PostViewModel(private val postFindUseCase: PostFindUseCase) : BaseViewModel() {

    val clickedCategoryIndex = MutableLiveData<Int>()
    var preClickedCategoryIndex = MutableLiveData<Int>()
    val clickedCategoryTitle = MutableLiveData<String>()


    override fun apply(event: Lifecycle.Event) {

    }

    fun categoryClicked(position: Int, title: String) {
        clickedCategoryIndex.value.run {
            if (this != position) {
                clickedCategoryTitle.value = title
                clickedCategoryIndex.value = position
            } else {
                clickedCategoryTitle.value = null
                clickedCategoryIndex.value = null
            }
        }

    }
}