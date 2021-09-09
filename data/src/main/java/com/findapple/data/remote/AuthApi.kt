package com.findapple.data.remote

import com.findapple.data.dto.request.LoginRequest
import com.findapple.data.dto.request.RegisterRequest
import com.findapple.data.dto.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth")
    fun login(@Body body: LoginRequest): Single<LoginResponse>

    @POST("/auth")
    fun register(@Body body: RegisterRequest): Single<Unit>
}