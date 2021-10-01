package com.findapple.data.features.mypage

import com.findapple.data.features.mypage.dto.response.UserResponse
import com.findapple.data.features.post.dto.response.UserPostListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("/info")
    fun getUser(): Single<UserResponse>

    @GET("/mypage")
    fun getUserPostList(): Single<List<UserPostListResponse>>
}