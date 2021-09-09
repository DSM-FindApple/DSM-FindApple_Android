package com.findapple.findapple.domain.auth.service

import com.findapple.findapple.domain.auth.`object`.RegisterObject
import com.findapple.findapple.domain.auth.entity.Auth
import com.findapple.findapple.domain.auth.entity.Token
import com.findapple.findapple.domain.base.Result
import io.reactivex.Single

interface AuthService {
    fun login(loginRequestData: Auth): Single<Result<Token>>

    fun register(registerRequest: RegisterObject): Single<Result<Unit>>
}