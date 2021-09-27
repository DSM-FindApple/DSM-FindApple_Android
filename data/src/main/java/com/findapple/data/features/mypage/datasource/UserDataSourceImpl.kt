package com.findapple.data.features.mypage.datasource

import com.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

class UserDataSourceImpl(): UserDataSource {
    override fun getUserInfo(): Single<User> {
        TODO("Not yet implemented")
    }
}