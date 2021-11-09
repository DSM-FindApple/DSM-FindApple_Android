package com.findapple.findapple.data.features.post.remote

import com.findapple.findapple.data.features.post.dto.request.PostFindRequest
import com.findapple.findapple.data.features.post.dto.request.PostLostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*

interface PostApi {
    @GET("/lostlist")
    fun getLostList(): Single<List<LostListResponse>>

    @GET("/find")
    fun getFindList(): Single<List<FindListResponse>>

    @POST("/find")
    fun postFind(@Part body: PostFindRequest): Single<Unit>

    @Multipart
    @POST("/lost")
    fun postLost(
        @Part("category") category: String,
        @Part("detail") detail: String,
        @Part("latitude") latitude: Double,
        @Part("longitude") longitude: Double,
        @Part("lostAt") lostAt: String,
        @Part("title") title: String,
        @Part images: List<MultipartBody.Part>
    ): Single<Unit>
}