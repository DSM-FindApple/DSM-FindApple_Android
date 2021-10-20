package com.findapple.presentation.di.module.main.post

import com.findapple.data.features.post.datasource.PostDataSource
import com.findapple.data.features.post.datasource.PostDataSourceImpl
import com.findapple.data.features.post.remote.PostApi
import com.findapple.data.features.post.repository.PostRepositoryImpl
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.post.repository.PostRepository
import com.findapple.domain.features.post.service.PostService
import com.findapple.domain.features.post.service.PostServiceImpl
import com.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.di.scope.MainFragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PostStaticModule {

    @FragmentScope
    @Provides
    fun postService(
        repository: PostRepository,
        errorHandler: ErrorHandler
    ): PostService = PostServiceImpl(repository, errorHandler)

    @FragmentScope
    @Provides
    fun postRepository(
        dataSource: PostDataSource
    ): PostRepository = PostRepositoryImpl(dataSource)

    @FragmentScope
    @Provides
    fun postDataSource(
        api: PostApi
    ): PostDataSource = PostDataSourceImpl(api)
}