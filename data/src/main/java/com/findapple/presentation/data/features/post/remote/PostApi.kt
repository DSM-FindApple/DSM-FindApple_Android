package com.findapple.presentation.data.features.post.remote

import com.findapple.presentation.data.features.post.dto.request.PostFindRequest
import com.findapple.presentation.data.features.post.dto.request.PostLostRequest
import com.findapple.presentation.data.features.post.dto.response.FindListResponse
import com.findapple.presentation.data.features.post.dto.response.LostListResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part

interface PostApi {
    @GET("/lostlist")
    fun getLostList(): Single<LostListResponse>

    @GET("/find")
    fun getFindList(): Single<FindListResponse>

    @POST("/find")
    fun postFind(@Part body: PostFindRequest): Single<Unit> //todo body 바꾸기

    @POST("/lost")
    fun postLost(@Body body: PostLostRequest): Single<Unit> //todo body 바꾸기
}