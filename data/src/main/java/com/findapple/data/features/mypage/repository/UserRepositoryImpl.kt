package com.findapple.data.features.mypage.repository

import com.findapple.data.features.mypage.datasource.UserDataSource
import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.mypage.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override fun getUserInfo(): Single<User> =
        userDataSource.getUserInfo()
}