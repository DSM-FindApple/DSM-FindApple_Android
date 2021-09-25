package com.findapple.presentation.domain.features.mypage.repository

import com.findapple.presentation.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserRepository {
    fun getUserInfo(): Single<User>
}