package com.findapple.presentation.features.find.post.viewModel

import androidx.lifecycle.Lifecycle
import com.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.presentation.base.BaseViewModel

class PostFindViewModel(private val postFindUseCase: PostFindUseCase) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {

    }
}