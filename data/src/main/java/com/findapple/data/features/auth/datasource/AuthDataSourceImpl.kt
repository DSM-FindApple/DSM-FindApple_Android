package com.findapple.data.features.auth.datasource

import com.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.data.features.auth.entity.AuthData
import com.findapple.data.features.auth.entity.toLoginRequest
import com.findapple.data.features.auth.remote.AuthApi
import com.findapple.data.local.database.dao.UserDao
import com.findapple.data.local.database.entity.toDatabaseEntity
import com.findapple.domain.entity.User
import io.reactivex.Single

class AuthDataSourceImpl(private val authApi: AuthApi, private val userDao: UserDao) :
    AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()

    override fun saveUserInfo(user: User): Single<Unit> =
        userDao.saveUserData(user.toDatabaseEntity())
}