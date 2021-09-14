package com.findapple.findapple.data.repository

import com.findapple.findapple.data.datasource.post.PostDataSource
import com.findapple.findapple.data.dto.response.toEntity
import com.findapple.findapple.domain.post.`object`.PostDataObject
import com.findapple.findapple.domain.post.entity.PostListData
import com.findapple.findapple.domain.post.repository.PostRepository
import io.reactivex.Single

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override fun getPostList(isLostList: Boolean): Single<PostListData> =
        if (isLostList) dataSource.getLostList().map { it.toEntity() } else dataSource.getFindList()
            .map { it.toEntity() }

    override fun postFeed(request: PostDataObject, isLost: Boolean): Single<Unit> =
        if(isLost) dataSource.postFind(request) else dataSource.postLost(request)

}