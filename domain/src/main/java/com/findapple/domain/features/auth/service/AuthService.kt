package com.findapple.domain.features.auth.service

import com.findapple.domain.features.auth.`object`.RegisterObject
import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.base.Result
import io.reactivex.Single

interface AuthService {
    fun login(loginRequestData: Auth): Single<Result<Token>>

    fun refreshToken(): Single<Result<Unit>>
}