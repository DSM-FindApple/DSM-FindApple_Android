package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import io.reactivex.Single

interface MainDataSource {
    fun checkLogin(): Single<Boolean>

    fun refreshToken(): Single<LoginResponse>

    fun getUserId(): Long
}