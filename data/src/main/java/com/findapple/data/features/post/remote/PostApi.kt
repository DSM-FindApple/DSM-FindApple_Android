package com.findapple.data.features.post.remote

import com.findapple.data.features.post.dto.request.PostFindRequest
import com.findapple.data.features.post.dto.request.PostLostRequest
import com.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.data.features.post.dto.response.UserPostListResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part

interface PostApi {
    @GET("/lostlist")
    fun getLostList(): Single<List<LostListResponse>>

    @GET("/find")
    fun getFindList(): Single<List<FindListResponse>>

    @GET("/mypage")
    fun getUserPostList(): Single<List<UserPostListResponse>>

    @POST("/find")
    fun postFind(@Part body: PostFindRequest): Single<Unit> //todo body 바꾸기

    @POST("/lost")
    fun postLost(@Body body: PostLostRequest): Single<Unit> //todo body 바꾸기
}