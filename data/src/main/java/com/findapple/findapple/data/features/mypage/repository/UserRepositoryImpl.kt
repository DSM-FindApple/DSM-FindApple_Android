package com.findapple.findapple.data.features.mypage.repository

import com.findapple.findapple.data.features.mypage.datasource.UserDataSource
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override fun getUserInfo(): Single<User> =
        userDataSource.getUserInfo()

    override fun getUserDetail(): Single<UserDetail> =
        userDataSource.getUserDetail()

}