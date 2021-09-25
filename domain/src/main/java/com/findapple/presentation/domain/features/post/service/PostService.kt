package com.findapple.presentation.domain.features.post.service

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.features.post.`object`.PostDataObject
import com.findapple.presentation.domain.features.post.entity.PostListData
import io.reactivex.Single


interface PostService {
    fun getPostList(isLostList: Boolean): Single<Result<PostListData>>

    fun postFeed(request: PostDataObject,isLost: Boolean): Single<Result<Unit>>
}