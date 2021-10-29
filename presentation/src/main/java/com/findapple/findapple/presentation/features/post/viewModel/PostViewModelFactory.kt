package com.findapple.findapple.presentation.features.post.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase

class PostViewModelFactory(private val postFindUseCase: PostFindUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(PostFindUseCase::class.java).newInstance(postFindUseCase)

}