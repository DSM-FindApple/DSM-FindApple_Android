package com.findapple.findapple.domain.features.mypage.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserService {
    fun getUserDetail(): Single<Result<UserDetail>>
}