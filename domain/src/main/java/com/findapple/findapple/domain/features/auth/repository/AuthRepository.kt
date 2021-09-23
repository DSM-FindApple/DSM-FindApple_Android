package com.findapple.findapple.domain.features.auth.repository

import com.findapple.findapple.domain.features.auth.`object`.RegisterObject
import com.findapple.findapple.domain.features.auth.entity.Auth
import com.findapple.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: Auth): Single<Token>

    fun register(registerRequest: RegisterObject): Single<Unit>

    fun refreshToken(): Single<Unit>
}