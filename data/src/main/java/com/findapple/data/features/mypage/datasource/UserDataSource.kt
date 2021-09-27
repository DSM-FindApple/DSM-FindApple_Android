package com.findapple.data.features.mypage.datasource

import com.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserDataSource {
    fun getUserInfo(): Single<User>
}