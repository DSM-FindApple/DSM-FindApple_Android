package com.findapple.findapple.domain.features.mypage.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import io.reactivex.Single

interface UserService {
    fun getUserDetail(): Single<Result<UserDetail>>

    fun logout(): Single<Result<Unit>>
}