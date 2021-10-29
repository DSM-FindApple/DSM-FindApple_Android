package com.findapple.findapple.domain.features.auth.repository

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.auth.parameter.LoginParameter
import com.findapple.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

interface AuthRepository {
    fun login(loginParameter: LoginParameter): Single<Token>

    fun refreshToken(): Single<Unit>

    fun saveUserInfo(user: User): Single<Unit>

}