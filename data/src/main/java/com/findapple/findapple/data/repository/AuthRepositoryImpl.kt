package com.findapple.findapple.data.repository

import com.findapple.findapple.data.`object`.toDataEntity
import com.findapple.findapple.data.datasource.auth.AuthDataSource
import com.findapple.findapple.data.dto.response.toEntity
import com.findapple.findapple.data.entity.toDataEntity
import com.findapple.findapple.domain.auth.`object`.RegisterObject
import com.findapple.findapple.domain.auth.entity.Auth
import com.findapple.findapple.domain.auth.entity.Token
import com.findapple.findapple.domain.auth.repository.AuthRepository
import io.reactivex.Single

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {
    override fun login(loginRequest: Auth): Single<Token> =
        authDataSource.login(loginRequest.toDataEntity()).map { it.toEntity() }

    override fun register(registerRequest: RegisterObject): Single<Unit> =
        authDataSource.register(registerRequest.toDataEntity())
}