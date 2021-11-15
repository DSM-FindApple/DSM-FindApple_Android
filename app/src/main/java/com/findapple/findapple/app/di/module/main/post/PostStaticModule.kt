package com.findapple.findapple.app.di.module.main.post

import com.findapple.findapple.data.features.post.datasource.PostDataSource
import com.findapple.findapple.data.features.post.datasource.PostDataSourceImpl
import com.findapple.findapple.data.features.post.remote.PostApi
import com.findapple.findapple.data.features.post.repository.PostRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.post.repository.PostRepository
import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.features.post.service.PostServiceImpl
import com.findapple.findapple.app.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

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