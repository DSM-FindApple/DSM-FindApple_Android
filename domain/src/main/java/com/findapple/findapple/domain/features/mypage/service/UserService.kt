package com.findapple.findapple.domain.features.mypage.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserService {
    fun getUserInfo(): Single<Result<User>>
}