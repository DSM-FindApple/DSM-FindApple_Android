package com.findapple.presentation.data.features.auth.datasource

import com.findapple.presentation.data.features.auth.dto.response.LoginResponse
import com.findapple.presentation.data.features.auth.entity.AuthData
import com.findapple.presentation.domain.features.auth.`object`.RegisterObject
import io.reactivex.Single

interface AuthDataSource {
    fun login(loginRequest: AuthData): Single<LoginResponse>

    fun register(registerRequest: RegisterObject): Single<Unit>

    fun refreshToken(): Single<Unit>
}