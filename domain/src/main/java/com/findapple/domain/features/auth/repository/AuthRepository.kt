package com.findapple.domain.features.auth.repository

import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: Auth): Single<Token>

    fun refreshToken(): Single<Unit>
}