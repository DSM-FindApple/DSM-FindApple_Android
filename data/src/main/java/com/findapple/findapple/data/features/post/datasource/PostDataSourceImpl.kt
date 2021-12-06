package com.findapple.findapple.data.features.post.datasource

import com.findapple.findapple.data.features.post.dto.request.GetPostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.findapple.data.features.post.remote.PostApi
import com.findapple.findapple.data.features.post.toMultipart
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import io.reactivex.Single

class PostDataSourceImpl(private val postApi: PostApi) : PostDataSource {
    override fun getLostList(parameter: GetPostRequest): Single<List<LostListResponse>> =
        postApi.getLostList(
            pageNum = parameter.pageNum,
            endLatitude = parameter.location.latitude.plus(0.1),
            startLatitude = parameter.location.latitude.minus(0.1),
            endLongitude = parameter.location.longitude.plus(0.1),
            startLongitude = parameter.location.longitude.minus(0.1)
        )

    override fun getFindList(parameter: GetPostRequest): Single<List<FindListResponse>> =
        postApi.getFindList(
            pageNum = parameter.pageNum,
            endLatitude = parameter.location.latitude.plus(0.1),
            startLatitude = parameter.location.latitude.minus(0.1),
            endLongitude = parameter.location.longitude.plus(0.1),
            startLongitude = parameter.location.longitude.minus(0.1)
        )

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


    override fun getRelatedLostPost(title: String): Single<List<FindListResponse>> =
        postApi.getRelatedLostPosts(0, title)

    override fun getRelatedFindPost(title: String): Single<List<LostListResponse>> =
         postApi.getRelatedFindPosts(0, title)

    override fun deletePost(post: Post, isLost: Boolean): Single<Unit> =
        if (isLost) postApi.deleteLostPost(post.id) else postApi.deleteFindPost(post.id)
}