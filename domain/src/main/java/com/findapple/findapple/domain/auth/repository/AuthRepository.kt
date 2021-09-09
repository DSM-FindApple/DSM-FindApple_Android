package com.findapple.findapple.domain.auth.repository

import com.findapple.findapple.domain.auth.`object`.RegisterObject
import com.findapple.findapple.domain.auth.entity.Auth
import com.findapple.findapple.domain.auth.entity.Token
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: Auth): Single<Token>

    fun register(registerRequest: RegisterObject): Single<Unit>
}