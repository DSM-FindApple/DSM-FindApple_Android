package com.findapple.findapple.data.features.post.remote

import com.findapple.findapple.data.features.post.dto.request.UpdateFindPostRequest
import com.findapple.findapple.data.features.post.dto.request.UpdateLostPostRequest
import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*

interface PostApi {
    @GET("lost/{pageNum}")
    fun getLostList(
        @Path("pageNum") pageNum: Int,
        @Query("endLatitude") endLatitude: Double,
        @Query("endLongitude") endLongitude: Double,
        @Query("startLatitude") startLatitude: Double,
        @Query("startLongitude") startLongitude: Double
    ): Single<List<LostListResponse>>

    @GET("find/{pageNum}")
    fun getFindList(
        @Path("pageNum") pageNum: Int,
        @Query("endLatitude") endLatitude: Double,
        @Query("endLongitude") endLongitude: Double,
        @Query("startLatitude") startLatitude: Double,
        @Query("startLongitude") startLongitude: Double
    ): Single<List<FindListResponse>>

    @Multipart
    @POST("find")
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
    @POST("lost")
    fun postLost(
        @Query("category") category: String,
        @Query("detail") detail: String,
        @Part images: List<MultipartBody.Part>,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("lostAt") lostAt: String,
        @Query("title") title: String
    ): Single<Unit>

    @GET("lost/relation/{pageNum}")
    fun getRelatedLostPosts(
        @Path("pageNum") pageNum: Int,
        @Query("title") title: String
    ): Single<List<FindListResponse>>

    @GET("find/relation/{pageNum}")
    fun getRelatedFindPosts(
        @Path("pageNum") pageNum: Int,
        @Query("title") title: String
    ): Single<List<LostListResponse>>

    @DELETE("lost/{lostId}")
    fun deleteLostPost(@Path("lostId") id: Long): Single<Unit>

    @DELETE("find/{findId}")
    fun deleteFindPost(@Path("findId") id: Long): Single<Unit>

    @PUT("lost/{listId}")
    fun updateLost(@Path("listId") listId: Long, @Body requestBodyLost: UpdateLostPostRequest): Single<Unit>

    @PUT("find/{listId}")
    fun updateFind(@Path("listId") listId: Long, @Body requestBody: UpdateFindPostRequest): Single<Unit>
}