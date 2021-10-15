package com.findapple.data.features.mypage.datasource

import com.findapple.domain.entity.User
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserDataSource {
    fun getUserInfo(): Single<User>

    fun getUserPostList(): Single<List<Post>>
}