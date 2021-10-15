package com.findapple.data.features.mypage.datasource

import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.post.dto.response.toEntity
import com.findapple.data.local.database.dao.UserDao
import com.findapple.data.local.database.entity.toEntity
import com.findapple.domain.entity.User
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

class UserDataSourceImpl(private val api: UserApi, private val userDao: UserDao) : UserDataSource {
    override fun getUserInfo(): Single<User> =
        userDao.getUserData().map { it.toEntity() }


    override fun getUserPostList(): Single<List<Post>> =
        api.getUserPostList().map { it.toEntity() }
}