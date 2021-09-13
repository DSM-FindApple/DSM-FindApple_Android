package com.findapple.findapple.data.remote

import com.findapple.findapple.data.dto.response.FindListResponse
import com.findapple.findapple.data.dto.response.LostListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {
    @GET("/lostlist")
    fun getLostList(): Single<LostListResponse>

    @GET("/find")
    fun getFindList(): Single<FindListResponse>
}