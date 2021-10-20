package com.findapple.presentation.di.module.post.find

import com.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.features.find.post.viewModel.PostFindViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PostFindModule {
    @FragmentScope
    @Provides
    fun providePostFindViewModelFactory(
        postFindUseCase: PostFindUseCase
    ): PostFindViewModelFactory = PostFindViewModelFactory(postFindUseCase)
}