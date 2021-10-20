package com.findapple.presentation.features.find.post.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.post.usecase.PostFindUseCase

class PostFindViewModelFactory(private val postFindUseCase: PostFindUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(PostFindUseCase::class.java).newInstance(postFindUseCase)

}