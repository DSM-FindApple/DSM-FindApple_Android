package com.findapple.findapple.domain.post.repository

import com.findapple.findapple.domain.post.`object`.PostDataObject
import com.findapple.findapple.domain.post.entity.PostListData
import io.reactivex.Single

interface PostRepository {
    fun getPostList(isLostList: Boolean): Single<PostListData>

    fun postFeed(request: PostDataObject,isLost: Boolean): Single<Unit>
}