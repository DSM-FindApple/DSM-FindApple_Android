package com.findapple.domain.features.mypage.service

import com.findapple.domain.base.Result
import com.findapple.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserService {
    fun getUserInfo(): Single<Result<User>>
}