package com.findapple.findapple.data.features.mypage.datasource

import com.findapple.findapple.data.features.mypage.dto.response.UserResponse
import com.findapple.findapple.domain.entity.User
import io.reactivex.Single

interface UserDataSource {
    fun getUserInfo(): Single<User>

    fun getUserDetail(): Single<UserResponse>

    fun logout(): Single<Unit>

    fun resetToken()
}