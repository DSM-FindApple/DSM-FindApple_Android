package com.findapple.presentation.di.module.post.find

import com.findapple.domain.features.post.service.PostService
import com.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.presentation.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PostFindStaticModule {
    @FragmentScope
    @Provides
    fun providePostFindUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): PostFindUseCase = PostFindUseCase(service, compositeDisposable)
}