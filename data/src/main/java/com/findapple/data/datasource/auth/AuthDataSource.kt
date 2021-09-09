package com.findapple.data.datasource.auth

import com.findapple.data.dto.request.LoginRequest
import com.findapple.data.dto.response.LoginResponse
import com.findapple.data.entity.AuthData
import io.reactivex.Single

interface AuthDataSource {
    fun login(loginRequest: AuthData):Single<LoginResponse>
}