package com.findapple.findapple.domain.features.mypage.repository

import com.findapple.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserRepository {
    fun getUserInfo(): Single<User>
}