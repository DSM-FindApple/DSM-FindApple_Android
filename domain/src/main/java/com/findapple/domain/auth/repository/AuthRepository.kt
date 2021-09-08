package com.findapple.domain.auth.repository

import com.findapple.domain.auth.request.LoginRequest
import com.findapple.domain.auth.request.RegisterRequest
import com.findapple.domain.auth.response.LoginResponse
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun register(registerRequest: RegisterRequest): Single<Unit>
}