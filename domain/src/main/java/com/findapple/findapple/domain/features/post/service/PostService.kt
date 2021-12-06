package com.findapple.findapple.domain.features.post.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.features.post.parameter.UpdateDataParameter
import io.reactivex.Single


interface PostService {
    fun getPostList(page: GetPostParameter, isLostList: Boolean): Single<Result<List<Post>>>

    fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Result<Unit>>

    fun getRelatedLostPost(title: String): Single<Result<List<Post>>>

    fun getRelatedFindPost(title: String): Single<Result<List<Post>>>

    fun deletePost(post: Post, isLost: Boolean): Single<Result<Unit>>

    fun updatePost(parameter: UpdateDataParameter): Single<Result<Unit>>
}