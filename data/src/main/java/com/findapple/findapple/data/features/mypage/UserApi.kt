package com.findapple.findapple.data.features.mypage

import com.findapple.findapple.data.features.mypage.dto.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("/user")
    fun getUserDetail(): Single<UserResponse>
}