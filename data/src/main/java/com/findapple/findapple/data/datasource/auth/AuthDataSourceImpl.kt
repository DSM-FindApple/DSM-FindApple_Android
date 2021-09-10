package com.findapple.findapple.data.datasource.auth

import com.findapple.findapple.data.`object`.RegisterObjectData
import com.findapple.findapple.data.`object`.toRegisterRequest
import com.findapple.findapple.data.dto.response.LoginResponse
import com.findapple.findapple.data.entity.AuthData
import com.findapple.findapple.data.entity.toLoginRequest
import com.findapple.findapple.data.remote.AuthApi
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi) : AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun register(registerRequest: RegisterObjectData): Single<Unit> =
        authApi.register(registerRequest.toRegisterRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()
}