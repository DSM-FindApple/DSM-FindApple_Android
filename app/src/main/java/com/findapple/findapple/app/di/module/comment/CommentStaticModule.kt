package com.findapple.findapple.app.di.module.comment

import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.data.features.comment.datasource.CommentDatasource
import com.findapple.findapple.data.features.comment.datasource.CommentDatasourceImpl
import com.findapple.findapple.data.features.comment.remote.CommentApi
import com.findapple.findapple.data.features.comment.repository.CommentRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.comment.repository.CommentRepository
import com.findapple.findapple.domain.features.comment.service.CommentService
import com.findapple.findapple.domain.features.comment.service.CommentServiceImpl
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase
import com.findapple.findapple.domain.features.comment.usecase.PostCommentUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class CommentStaticModule {
    @FragmentScope
    @Provides
    fun provideGetCommentsUseCase(
        commentService: CommentService,
        compositeDisposable: CompositeDisposable
    ): GetCommentsUseCase = GetCommentsUseCase(commentService, compositeDisposable)

    @FragmentScope
    @Provides
    fun providePostCommentUseCase(
        commentService: CommentService,
        compositeDisposable: CompositeDisposable
    ): PostCommentUseCase = PostCommentUseCase(commentService, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideCommentService(
        commentRepository: CommentRepository,
        errorHandler: ErrorHandler
    ): CommentService = CommentServiceImpl(commentRepository, errorHandler)

    @FragmentScope
    @Provides
    fun provideCommentRepository(
        dataSource: CommentDatasource
    ): CommentRepository = CommentRepositoryImpl(dataSource)

    @FragmentScope
    @Provides
    fun provideCommentDataSource(
        api: CommentApi
    ): CommentDatasource = CommentDatasourceImpl(api)
}