package com.findapple.findapple.app.di.module.comment

import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.comment.viewmodel.CommentViewModelFactory
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase
import dagger.Module
import dagger.Provides

@Module
class CommentModule {
    @FragmentScope
    @Provides
    fun provideCommentViewModelFactory(
        getCommentsUseCase: GetCommentsUseCase
    ): CommentViewModelFactory =
        CommentViewModelFactory(getCommentsUseCase)

}