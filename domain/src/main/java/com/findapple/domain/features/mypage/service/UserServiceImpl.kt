package com.findapple.domain.features.mypage.service

import com.findapple.domain.base.Result
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.domain.toResult
import io.reactivex.Single

class UserServiceImpl(
    private val repository: UserRepository,
    private val errorHandler: ErrorHandler
) : UserService {
    override fun getUserInfo(): Single<Result<User>> =
        repository.getUserInfo().toResult(errorHandler)
}