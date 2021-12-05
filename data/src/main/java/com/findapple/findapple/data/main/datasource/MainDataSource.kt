package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import io.reactivex.Single

interface MainDataSource {
    fun checkLogin(): Single<String>

    fun refreshToken(): Single<LoginResponse>

    fun getUserId(): Long

    fun getChatRoomId(id: Long): Single<String>
}