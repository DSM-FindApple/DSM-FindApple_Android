package com.findapple.findapple.data.features.post.datasource

import com.findapple.findapple.data.features.post.dto.request.GetRelatedPostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.findapple.data.features.post.remote.PostApi
import com.findapple.findapple.data.features.post.toMultipart
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import io.reactivex.Single

class PostDataSourceImpl(private val postApi: PostApi) : PostDataSource {
    override fun getLostList(): Single<List<LostListResponse>> =
        postApi.getLostList()

    override fun getFindList(): Single<List<FindListResponse>> =
        postApi.getFindList()

    override fun postFind(request: PostDataParameter): Single<Unit> =
        postApi.postFind(
            title = request.title,
            detail = request.detail,
            category = request.category,
            latitude = request.locationInfo.latitude,
            longitude = request.locationInfo.longitude,
            findAt = request.actionTime,
            images = request.images.toMultipart()
        )

    override fun postLost(request: PostDataParameter): Single<Unit> =
         postApi.postLost(
            title = request.title,
            detail = request.detail,
            category = request.category,
            latitude = request.locationInfo.latitude,
            longitude = request.locationInfo.longitude,
            lostAt = request.actionTime,
            images = request.images.toMultipart()
        )


    override fun getRelatedLostPost(title: String): Single<List<LostListResponse>> =
        postApi.getRelatedLostPosts(0, GetRelatedPostRequest(title))
}