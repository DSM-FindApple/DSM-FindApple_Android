package com.findapple.findapple.domain.main.repository

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

interface MainRepository {
    fun checkLogin(): Single<String>

    fun refreshToken(): Single<Token>

    fun getUserId(): Long

    fun getChatRoomId(id: Long): Single<Result<String>>
}