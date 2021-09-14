package com.findapple.findapple.presentation.di.module.main.post

import com.findapple.findapple.data.datasource.post.PostDataSource
import com.findapple.findapple.data.datasource.post.PostDataSourceImpl
import com.findapple.findapple.data.remote.PostApi
import com.findapple.findapple.data.repository.PostRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.post.repository.PostRepository
import com.findapple.findapple.domain.post.service.PostService
import com.findapple.findapple.domain.post.service.PostServiceImpl
import com.findapple.findapple.domain.post.usecase.GetLostListUseCase
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PostStaticModule {

    @MainFragmentScope
    @Provides
    fun getLostListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetLostListUseCase = GetLostListUseCase(service, compositeDisposable)

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