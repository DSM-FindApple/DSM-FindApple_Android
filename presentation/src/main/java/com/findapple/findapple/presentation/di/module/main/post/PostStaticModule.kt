package com.findapple.findapple.presentation.di.module.main.post

import com.findapple.findapple.data.features.mypage.datasource.PostDataSource
import com.findapple.findapple.data.features.mypage.datasource.PostDataSourceImpl
import com.findapple.findapple.data.features.post.remote.PostApi
import com.findapple.findapple.data.features.post.repository.PostRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.post.repository.PostRepository
import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.features.post.service.PostServiceImpl
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PostStaticModule {

    @MainFragmentScope
    @Provides
    fun provideLostListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetLostListUseCase = GetLostListUseCase(service, compositeDisposable)

    @MainFragmentScope
    @Provides
    fun provideFindListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetFindListUseCase = GetFindListUseCase(service, compositeDisposable)


    @MainFragmentScope
    @Provides
    fun postService(
        repository: PostRepository,
        errorHandler: ErrorHandler
    ): PostService = PostServiceImpl(repository, errorHandler)

    @MainFragmentScope
    @Provides
    fun postRepository(
        dataSource: PostDataSource
    ): PostRepository = PostRepositoryImpl(dataSource)

    @MainFragmentScope
    @Provides
    fun postDataSource(
        api: PostApi
    ): PostDataSource = PostDataSourceImpl(api)
}