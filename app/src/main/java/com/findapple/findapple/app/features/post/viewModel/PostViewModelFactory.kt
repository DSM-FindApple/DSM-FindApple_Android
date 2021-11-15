package com.findapple.findapple.app.features.post.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.domain.features.post.usecase.PostLostUseCase

class PostViewModelFactory(
    private val postFindUseCase: PostFindUseCase,
    private val postLostUseCase: PostLostUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(PostFindUseCase::class.java, PostLostUseCase::class.java)
            .newInstance(postFindUseCase, postLostUseCase)

}