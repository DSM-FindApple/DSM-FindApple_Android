package com.findapple.findapple.domain.features.post.repository

import com.findapple.findapple.domain.features.post.`object`.PostDataObject
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface PostRepository {
    fun getPostList(isLostList: Boolean): Single<List<Post>>

    fun postFeed(request: PostDataObject,isLost: Boolean): Single<Unit>

    fun userPostList(): Single<Post>
}