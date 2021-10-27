package com.findapple.domain.features.auth.service

import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.base.Result
import com.findapple.domain.features.auth.parameter.LoginParameter
import io.reactivex.Single

interface AuthService {
    fun login(loginParameterData: LoginParameter): Single<Result<Token>>

    fun refreshToken(): Single<Result<Unit>>
}