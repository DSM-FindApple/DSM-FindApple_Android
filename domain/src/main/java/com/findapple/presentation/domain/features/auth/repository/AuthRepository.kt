package com.findapple.presentation.domain.features.auth.repository

import com.findapple.presentation.domain.features.auth.`object`.RegisterObject
import com.findapple.presentation.domain.features.auth.entity.Auth
import com.findapple.presentation.domain.features.auth.entity.Token
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: Auth): Single<Token>

    fun register(registerRequest: RegisterObject): Single<Unit>

    fun refreshToken(): Single<Unit>
}