package com.findapple.data.features.mypage.datasource

import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.mypage.dto.response.toEntity
import com.findapple.data.features.post.dto.response.toEntity
import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

class UserDataSourceImpl(private val api: UserApi) : UserDataSource {
    override fun getUserInfo(): Single<User> =
        api.getUser().map { it.toEntity() }

    override fun getUserPostList(): Single<List<Post>> =
        api.getUserPostList().map { it.toEntity() }
}