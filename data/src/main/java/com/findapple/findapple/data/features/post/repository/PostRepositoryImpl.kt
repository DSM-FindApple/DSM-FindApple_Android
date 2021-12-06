package com.findapple.findapple.data.features.post.repository

import com.findapple.findapple.data.features.post.datasource.PostDataSource
import com.findapple.findapple.data.features.post.dto.request.toDataRequest
import com.findapple.findapple.data.features.post.dto.response.toEntity
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.features.post.repository.PostRepository
import io.reactivex.Single

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override fun getPostList(parameter: GetPostParameter, isLostList: Boolean): Single<List<Post>> =
        if (isLostList) dataSource.getLostList(parameter.toDataRequest()).map { it.toEntity() }
        else dataSource.getFindList(parameter.toDataRequest()).map { it.toEntity() }

    override fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Unit> =
        if(isLost) dataSource.postLost(request) else dataSource.postFind(request)

    override fun getRelatedLostPost(title: String): Single<List<Post>> =
        dataSource.getRelatedLostPost(title).map { it.toEntity() }

    override fun getRelatedFindPost(title: String): Single<List<Post>> =
        dataSource.getRelatedFindPost(title).map { it.toEntity() }

    override fun deletePost(post: Post, isLost: Boolean): Single<Unit> =
        dataSource.deletePost(post, isLost)

    override fun updatePost(id: Long, parameter: PostDataParameter, isLost: Boolean) {
        dataSource.updatePost(id, parameter, isLost)
    }
}