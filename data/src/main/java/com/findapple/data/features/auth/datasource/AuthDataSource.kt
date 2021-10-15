package com.findapple.data.features.auth.datasource

import com.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.data.features.auth.entity.AuthData
import com.findapple.domain.entity.User
import com.findapple.domain.features.auth.`object`.RegisterObject
import io.reactivex.Single

interface AuthDataSource {
    fun login(loginRequest: AuthData): Single<LoginResponse>

    fun refreshToken(): Single<Unit>

    fun saveUserInfo(user: User): Single<Unit>
}