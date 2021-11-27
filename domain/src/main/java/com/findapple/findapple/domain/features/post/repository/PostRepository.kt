package com.findapple.findapple.domain.features.post.repository

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import io.reactivex.Single

interface PostRepository {
    fun getPostList(parameter: GetPostParameter, isLostList: Boolean): Single<List<Post>>

    fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Unit>

    fun getRelatedLostPost(title: String): Single<List<Post>>

    fun getRelatedFindPost(title: String): Single<List<Post>>
}