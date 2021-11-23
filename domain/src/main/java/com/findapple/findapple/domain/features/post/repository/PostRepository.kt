package com.findapple.findapple.domain.features.post.repository

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface PostRepository {
    fun getPostList(page: Int, isLostList: Boolean): Single<List<Post>>

    fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Unit>

    fun getRelatedLostPost(title: String): Single<List<Post>>
}