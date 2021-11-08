package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

class MainDataSourceImpl(private val localStorage: LocalStorage, private val authApi: AuthApi) : MainDataSource {
    override fun checkLogin(): Single<Boolean> =
        Single.just(localStorage.getString("access").isNotEmpty())

    override fun refreshToken(): Single<LoginResponse> =
        authApi.refreshToken()


}