package com.findapple.findapple.data.features.auth.repository

import com.findapple.findapple.data.features.auth.datasource.AuthDataSource
import com.findapple.findapple.data.features.auth.dto.response.toEntity
import com.findapple.findapple.data.features.auth.entity.toDataEntity
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.auth.parameter.LoginParameter
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.features.auth.repository.AuthRepository
import io.reactivex.Single

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val localStorage: LocalStorage
) : AuthRepository {
    override fun login(loginParameter: LoginParameter): Single<Token> {
        return authDataSource.login(loginParameter.toDataEntity(localStorage.getString("device_token")))
            .map {
                localStorage.run {
                    saveToken(it.accessToken, true)
                    saveToken(it.refreshToken, false)
                }
                it.toEntity()
            }
    }

    override fun saveUserInfo(user: User): Single<Unit> =
        authDataSource.saveUserInfo(user)

}