package com.findapple.findapple.data.features.post.datasource

import com.findapple.findapple.data.features.post.dto.request.toFindRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.findapple.data.features.post.remote.PostApi
import com.findapple.findapple.data.features.post.toMultipartPart
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import io.reactivex.Single

class PostDataSourceImpl(private val postApi: PostApi) : PostDataSource {
    override fun getLostList(): Single<List<LostListResponse>> =
        postApi.getLostList()

    override fun getFindList(): Single<List<FindListResponse>> =
        postApi.getFindList()

    override fun postFind(request: PostDataParameter): Single<Unit> =
        postApi.postFind(request.toFindRequest())

    override fun postLost(request: PostDataParameter): Single<Unit> {
        return postApi.postLost(
            title = request.title,
            detail = request.detail,
            category = request.category,
            latitude = request.locationInfo.latitude,
            longitude = request.locationInfo.longitude,
            lostAt = request.actionTime,
            images = request.images.map {
                it.toMultipartPart()
            }
        )
    }


    override fun getRelatedLostPost(): Single<List<Post>> {
        TODO("Not yet implemented")
    }
}