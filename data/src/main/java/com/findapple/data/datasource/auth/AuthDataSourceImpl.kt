package com.findapple.data.datasource.auth

import com.findapple.data.dto.response.LoginResponse
import com.findapple.data.entity.AuthData
import com.findapple.data.entity.toLoginRequest
import com.findapple.data.remote.AuthApi
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi) :AuthDataSource{
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

}