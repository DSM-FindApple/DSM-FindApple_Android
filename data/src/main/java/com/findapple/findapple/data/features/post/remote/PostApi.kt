package com.findapple.findapple.data.features.post.remote

import com.findapple.findapple.data.features.post.dto.request.GetRelatedPostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*

interface PostApi {
    @GET("/lost/{pageNum}")
    fun getLostList(@Path("pageNum") pageNum: Int): Single<List<LostListResponse>>

    @GET("/find/{pageNum}")
    fun getFindList(@Path("pageNum") pageNum: Int): Single<List<FindListResponse>>

    @Multipart
    @POST("/find")
    fun postFind(
        @Query("category") category: String,
        @Query("detail") detail: String,
        @Part images: List<MultipartBody.Part>,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("findAt") findAt: String,
        @Query("title") title: String
    ): Single<Unit>

    @Multipart
    @POST("/lost")
    fun postLost(
        @Query("category") category: String,
        @Query("detail") detail: String,
        @Part images: List<MultipartBody.Part>,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("lostAt") lostAt: String,
        @Query("title") title: String
    ): Single<Unit>

    @GET("/lost/{pageNum}")
    fun getRelatedLostPosts(
        @Path("pageNum") pageNum: Int,
        @Body body: GetRelatedPostRequest
    ): Single<List<LostListResponse>>

}