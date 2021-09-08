package com.findapple.domain.auth.service

import com.findapple.domain.auth.request.LoginRequest
import com.findapple.domain.auth.request.RegisterRequest
import com.findapple.domain.auth.response.LoginResponse
import com.findapple.domain.base.Result
import io.reactivex.Single

interface AuthService {
    fun login(loginRequestData:LoginRequest): Single<Result<LoginResponse>>

    fun register(registerRequest: RegisterRequest): Single<Result<Unit>>
}