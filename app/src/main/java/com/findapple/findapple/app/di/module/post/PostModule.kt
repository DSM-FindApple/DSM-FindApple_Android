package com.findapple.findapple.app.di.module.post

import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.post.viewModel.PostViewModelFactory
import com.findapple.findapple.domain.features.post.usecase.*
import dagger.Module
import dagger.Provides

@Module
class PostModule {
    @FragmentScope
    @Provides
    fun providePostViewModelFactory(
        postFindUseCase: PostFindUseCase,
        postLostUseCase: PostLostUseCase,
        getRelatedLostPostUseCase: GetRelatedLostPostUseCase,
        getRelatedFindPostUseCase: GetRelatedFindPostUseCase,
        updatePostUseCase: UpdatePostUseCase
    ): PostViewModelFactory = PostViewModelFactory(postFindUseCase, postLostUseCase, getRelatedLostPostUseCase, getRelatedFindPostUseCase, updatePostUseCase)
}