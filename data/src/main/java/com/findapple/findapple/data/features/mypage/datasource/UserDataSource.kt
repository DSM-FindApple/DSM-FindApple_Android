package com.findapple.findapple.data.features.mypage.datasource

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserDataSource {
    fun getUserInfo(): Single<User>

    fun getUserPostList(): Single<List<Post>>
}