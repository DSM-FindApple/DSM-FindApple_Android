package com.findapple.data.features.mypage.repository

import com.findapple.data.features.mypage.datasource.UserDataSource
import com.findapple.domain.entity.User
import com.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override fun getUserInfo(): Single<User> =
        userDataSource.getUserInfo()

    override fun userPostList(): Single<List<Post>> {
        TODO("Not yet implemented")
    }
}