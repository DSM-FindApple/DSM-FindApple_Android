package com.findapple.data.features.auth.repository

import com.findapple.data.features.auth.datasource.AuthDataSource
import com.findapple.data.features.auth.dto.response.toEntity
import com.findapple.data.features.auth.entity.toDataEntity
import com.findapple.domain.features.auth.`object`.RegisterObject
import com.findapple.domain.features.auth.entity.Auth
import com.findapple.domain.features.auth.entity.Token
import com.findapple.domain.features.auth.repository.AuthRepository
import io.reactivex.Single

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {
    override fun login(loginRequest: Auth): Single<Token> =
        authDataSource.login(loginRequest.toDataEntity()).map { it.toEntity() }

    override fun register(registerRequest: RegisterObject): Single<Unit> =
        authDataSource.register(registerRequest)

    override fun refreshToken(): Single<Unit> =
        authDataSource.refreshToken()

}