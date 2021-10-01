package com.findapple.data.features.post.datasource

import com.findapple.data.features.post.dto.request.toFindRequest
import com.findapple.data.features.post.dto.request.toLostRequest
import com.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.data.features.post.dto.response.UserPostListResponse
import com.findapple.data.features.post.remote.PostApi
import com.findapple.domain.features.post.`object`.PostDataObject
import io.reactivex.Single

class PostDataSourceImpl(private val postApi: PostApi) : PostDataSource {
    override fun getLostList(): Single<List<LostListResponse>> =
        postApi.getLostList()

    override fun getFindList(): Single<List<FindListResponse>> =
        postApi.getFindList()

    override fun getUserPostList(): Single<List<UserPostListResponse>> =
        postApi.getUserPostList()

    override fun postFind(request: PostDataObject): Single<Unit> =
        postApi.postFind(request.toFindRequest())

    override fun postLost(request: PostDataObject): Single<Unit> =
        postApi.postLost(request.toLostRequest())
}