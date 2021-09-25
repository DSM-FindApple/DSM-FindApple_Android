package com.findapple.presentation.data.features.auth.datasource

import com.findapple.presentation.data.features.auth.dto.request.toRequest
import com.findapple.presentation.data.features.auth.dto.response.LoginResponse
import com.findapple.presentation.data.features.auth.entity.AuthData
import com.findapple.presentation.data.features.auth.entity.toLoginRequest
import com.findapple.presentation.data.features.auth.remote.AuthApi
import com.findapple.presentation.domain.features.auth.`object`.RegisterObject
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi) : AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun register(registerRequest: RegisterObject): Single<Unit> =
        authApi.register(registerRequest.toRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()
}