package com.findapple.data.features.mypage.repository

import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.mypage.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl: UserRepository {
    override fun getUserInfo(): Single<User> {
        TODO("Not yet implemented")
    }
}