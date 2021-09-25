package com.findapple.presentation.domain.features.mypage.service

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.features.mypage.entity.User
import io.reactivex.Single

interface UserService {
    fun getUserInfo(): Single<Result<User>>
}