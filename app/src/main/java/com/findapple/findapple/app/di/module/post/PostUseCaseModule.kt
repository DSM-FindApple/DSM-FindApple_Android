package com.findapple.findapple.app.di.module.post

import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.domain.features.post.usecase.PostLostUseCase
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.domain.features.post.usecase.GetRelatedFindPostUseCase
import com.findapple.findapple.domain.features.post.usecase.GetRelatedLostPostUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PostUseCaseModule {
    @FragmentScope
    @Provides
    fun providePostFindUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): PostFindUseCase = PostFindUseCase(service, compositeDisposable)

    @FragmentScope
    @Provides
    fun providePostLostUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): PostLostUseCase = PostLostUseCase(service, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideGetRelatedLostPostUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetRelatedLostPostUseCase = GetRelatedLostPostUseCase(service, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideGetRelatedFindPostUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetRelatedFindPostUseCase = GetRelatedFindPostUseCase(service, compositeDisposable)
}