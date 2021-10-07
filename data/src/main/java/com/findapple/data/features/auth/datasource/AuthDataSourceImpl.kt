package com.findapple.data.features.auth.datasource

import com.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.data.features.auth.entity.AuthData
import com.findapple.data.features.auth.entity.toLoginRequest
import com.findapple.data.features.auth.remote.AuthApi
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi) : AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()
}