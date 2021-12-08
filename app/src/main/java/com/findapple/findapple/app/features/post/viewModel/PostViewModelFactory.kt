package com.findapple.findapple.app.features.post.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.*

class PostViewModelFactory(
    private val postFindUseCase: PostFindUseCase,
    private val postLostUseCase: PostLostUseCase,
    private val getRelatedLostPostUseCase: GetRelatedLostPostUseCase,
    private val getRelatedFindPostUseCase: GetRelatedFindPostUseCase,
    private val updatePostUseCase: UpdatePostUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(PostFindUseCase::class.java, PostLostUseCase::class.java, GetRelatedLostPostUseCase::class.java, GetRelatedFindPostUseCase::class.java, UpdatePostUseCase::class.java)
            .newInstance(postFindUseCase, postLostUseCase, getRelatedLostPostUseCase, getRelatedFindPostUseCase, updatePostUseCase)

}