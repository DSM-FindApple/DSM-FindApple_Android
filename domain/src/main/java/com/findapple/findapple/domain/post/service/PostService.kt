package com.findapple.findapple.domain.post.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.post.entity.PostListData
import io.reactivex.Single


interface PostService {
    fun getPostList(isLostList: Boolean): Single<Result<PostListData>>

    fun postFeed(isLost: Boolean): Single<Result<Unit>>
}