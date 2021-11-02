package com.findapple.findapple.domain.features.post.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single


interface PostService {
    fun getPostList(isLostList: Boolean): Single<Result<List<Post>>>

    fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Result<Unit>>
}