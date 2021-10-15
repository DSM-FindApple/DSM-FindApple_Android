package com.findapple.domain.features.mypage.repository

import com.findapple.domain.entity.User
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserRepository {
    fun getUserInfo(): Single<User>

    fun userPostList(): Single<List<Post>>
}