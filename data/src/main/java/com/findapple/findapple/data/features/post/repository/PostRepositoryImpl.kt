package com.findapple.findapple.data.features.post.repository

import com.findapple.findapple.data.features.post.datasource.PostDataSource
import com.findapple.findapple.data.features.post.dto.response.toEntity
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.repository.PostRepository
import io.reactivex.Single

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override fun getPostList(isLostList: Boolean): Single<List<Post>> =
        if (isLostList) dataSource.getLostList().map { it.toEntity() } else dataSource.getFindList()
            .map { it.toEntity() }

    override fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Unit> =
        if(isLost) dataSource.postLost(request) else dataSource.postFind(request)

    override fun getRelatedLostPost(title: String): Single<List<Post>> {
        TODO("Not yet implemented")
    }

}