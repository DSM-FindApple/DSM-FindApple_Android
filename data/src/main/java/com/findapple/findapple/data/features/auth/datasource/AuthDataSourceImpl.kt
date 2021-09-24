package com.findapple.findapple.data.features.auth.datasource

import com.findapple.findapple.data.dto.request.toRequest
import com.findapple.findapple.data.dto.response.LoginResponse
import com.findapple.findapple.data.entity.AuthData
import com.findapple.findapple.data.entity.toLoginRequest
import com.findapple.findapple.data.features.auth.datasource.AuthDataSource
import com.findapple.findapple.data.remote.AuthApi
import com.findapple.findapple.domain.features.auth.`object`.RegisterObject
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi) : AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun register(registerRequest: RegisterObject): Single<Unit> =
        authApi.register(registerRequest.toRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()
}