package com.findapple.findapple.data.datasource.auth

import com.findapple.findapple.data.`object`.RegisterObjectData
import com.findapple.findapple.data.dto.response.LoginResponse
import com.findapple.findapple.data.entity.AuthData
import io.reactivex.Single

interface AuthDataSource {
    fun login(loginRequest: AuthData): Single<LoginResponse>

    fun register(registerRequest: RegisterObjectData): Single<Unit>

    fun refreshToken(): Single<Unit>
}