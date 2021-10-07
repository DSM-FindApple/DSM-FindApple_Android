package com.findapple.data.features.auth.remote

import com.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.data.features.auth.dto.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth")
    fun login(@Body body: LoginRequest): Single<LoginResponse>

    @GET("/auth/refresh")
    fun refreshToken(): Single<Unit>
}