package com.findapple.data.repository

import com.findapple.data.datasource.auth.AuthDataSource
import com.findapple.data.dto.response.toEntity
import com.findapple.data.entity.toDataEntity
import com.findapple.domain.auth.`object`.RegisterObject
import com.findapple.domain.auth.entity.Auth
import com.findapple.domain.auth.entity.Token
import com.findapple.domain.auth.repository.AuthRepository
import io.reactivex.Single

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {
    override fun login(loginRequest: Auth): Single<Token> =
        authDataSource.login(loginRequest.toDataEntity()).map { it.toEntity() }

    override fun register(registerRequest: RegisterObject): Single<Unit> {
        TODO("Not yet implemented")
    }
}