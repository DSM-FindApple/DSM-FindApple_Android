package com.findapple.domain.features.post.repository

import com.findapple.domain.features.post.`object`.PostDataObject
import com.findapple.domain.features.post.entity.PostListData
import io.reactivex.Single

interface PostRepository {
    fun getPostList(isLostList: Boolean): Single<PostListData>

    fun postFeed(request: PostDataObject,isLost: Boolean): Single<Unit>
}