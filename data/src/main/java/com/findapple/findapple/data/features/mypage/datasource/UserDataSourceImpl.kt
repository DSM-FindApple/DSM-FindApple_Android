package com.findapple.findapple.data.features.mypage.datasource

import com.findapple.findapple.data.features.mypage.UserApi
import com.findapple.findapple.data.features.post.dto.response.toEntity
import com.findapple.findapple.data.local.database.dao.UserDao
import com.findapple.findapple.data.local.database.entity.toEntity
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

class UserDataSourceImpl(private val api: UserApi, private val userDao: UserDao, private val localStorage: LocalStorage) : UserDataSource {
    override fun getUserInfo(): Single<User>{
        val id = localStorage.getLong("user_id")
        return userDao.getUserData(id).map { it.toEntity() }
    }

    override fun getUserPostList(): Single<List<Post>> =
        api.getUserPostList().map { it.toEntity() }
}