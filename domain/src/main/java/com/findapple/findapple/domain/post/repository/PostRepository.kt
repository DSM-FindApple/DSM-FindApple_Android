package com.findapple.findapple.domain.post.repository

import com.findapple.findapple.domain.post.entity.PostListData
import io.reactivex.Single

interface PostRepository {
    fun getPostList(isLostList: Boolean): Single<PostListData>

    fun postFeed(isLost: Boolean): Single<Unit>
}