package com.findapple.findapple.domain.features.mypage.repository

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserRepository {
    fun getUserInfo(): Single<User>

    fun userPostList(): Single<List<Post>>
}