package com.findapple.data.features.mypage.datasource

import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.mypage.dto.response.toEntity
import com.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

class UserDataSourceImpl(private val api: UserApi) : UserDataSource {
    override fun getUserInfo(): Single<User> =
        api.getUser().map { it.toEntity() }
}