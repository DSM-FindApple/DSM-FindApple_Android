package com.findapple.domain.features.post.service

import com.findapple.domain.base.Result
import com.findapple.domain.features.post.`object`.PostDataObject
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single


interface PostService {
    fun getPostList(isLostList: Boolean): Single<Result<List<Post>>>

    fun postFeed(request: PostDataObject,isLost: Boolean): Single<Result<Unit>>
}