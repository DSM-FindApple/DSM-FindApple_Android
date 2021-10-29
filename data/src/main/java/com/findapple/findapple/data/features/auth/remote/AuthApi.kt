package com.findapple.findapple.data.features.auth.remote

import com.findapple.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.*

interface AuthApi {
    @POST("/auth")
    fun login(@Body body: LoginRequest): Single<LoginResponse>

    @PUT("/auth")
    fun refreshToken(): Single<Unit>
}