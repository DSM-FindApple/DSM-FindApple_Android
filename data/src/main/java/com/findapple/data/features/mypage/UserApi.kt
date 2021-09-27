package com.findapple.data.features.mypage

import com.findapple.data.features.mypage.dto.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("")
    fun getUser(): Single<UserResponse>
}