package com.findapple.findapple.data.features.post.datasource

import com.findapple.findapple.data.features.post.dto.request.GetPostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import io.reactivex.Single

interface PostDataSource {
    fun getLostList(parameter: GetPostRequest): Single<List<LostListResponse>>

    fun getFindList(parameter: GetPostRequest): Single<List<FindListResponse>>

    fun postFind(request: PostDataParameter): Single<Unit>

    fun postLost(request: PostDataParameter): Single<Unit>

    fun getRelatedLostPost(title: String): Single<List<FindListResponse>>

    fun getRelatedFindPost(title: String): Single<List<LostListResponse>>

    fun deletePost(post: Post, isLost: Boolean): Single<Unit>

    fun updatePost(id: Long, post: PostDataParameter, isLost: Boolean): Single<Unit>
}