package com.findapple.findapple.data.remote

import com.findapple.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.findapple.data.dto.request.RegisterRequest
import com.findapple.findapple.data.dto.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth")
    fun login(@Body body: LoginRequest): Single<LoginResponse>

    @POST("/auth")
    fun register(@Body body: RegisterRequest): Single<Unit>

    @GET("/auth/refresh")
    fun refreshToken(): Single<Unit>
}