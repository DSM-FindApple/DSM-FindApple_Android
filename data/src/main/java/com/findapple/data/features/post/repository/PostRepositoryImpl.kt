package com.findapple.data.features.post.repository

import com.findapple.data.features.mypage.datasource.PostDataSource
import com.findapple.data.features.post.dto.response.toEntity
import com.findapple.domain.features.post.`object`.PostDataObject
import com.findapple.domain.features.post.entity.PostListData
import com.findapple.domain.features.post.repository.PostRepository
import io.reactivex.Single

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override fun getPostList(isLostList: Boolean): Single<PostListData> =
        if (isLostList) dataSource.getLostList().map { it.toEntity() } else dataSource.getFindList()
            .map { it.toEntity() }

    override fun postFeed(request: PostDataObject, isLost: Boolean): Single<Unit> =
        if(isLost) dataSource.postFind(request) else dataSource.postLost(request)

}