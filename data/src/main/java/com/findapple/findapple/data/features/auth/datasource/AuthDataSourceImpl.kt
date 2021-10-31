package com.findapple.findapple.data.features.auth.datasource

import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.findapple.data.features.auth.entity.AuthData
import com.findapple.findapple.data.features.auth.entity.toLoginRequest
import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.local.database.dao.UserDao
import com.findapple.findapple.data.local.database.entity.toDatabaseEntity
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.domain.entity.User
import io.reactivex.Single

class AuthDataSourceImpl(
    private val authApi: AuthApi,
    private val userDao: UserDao,
    private val localStorage: LocalStorage
) :
    AuthDataSource {
    override fun login(loginRequest: AuthData): Single<LoginResponse> =
        authApi.login(loginRequest.toLoginRequest())

    override fun refreshToken(): Single<Unit> =
        authApi.refreshToken()

    override fun saveUserInfo(user: User): Single<Unit> {
        localStorage.saveLong("user_id", user.id)
        return userDao.saveUserData(user.toDatabaseEntity())
    }

}