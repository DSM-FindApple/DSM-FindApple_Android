package com.findapple.findapple.data.datasource.auth

import com.findapple.findapple.data.dto.response.LoginResponse
import com.findapple.findapple.data.entity.AuthData
import com.findapple.findapple.domain.features.auth.`object`.RegisterObject
import io.reactivex.Single

interface AuthDataSource {
    fun login(loginRequest: AuthData): Single<LoginResponse>

    fun register(registerRequest: RegisterObject): Single<Unit>

    fun refreshToken(): Single<Unit>
}