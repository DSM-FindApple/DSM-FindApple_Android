package com.findapple.findapple.presentation.di.module.post

import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.domain.features.post.usecase.PostLostUseCase
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.features.post.viewModel.PostViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PostFindModule {
    @FragmentScope
    @Provides
    fun providePostFindViewModelFactory(
        postFindUseCase: PostFindUseCase,
        postLostUseCase: PostLostUseCase
    ): PostViewModelFactory = PostViewModelFactory(postFindUseCase, postLostUseCase)
}