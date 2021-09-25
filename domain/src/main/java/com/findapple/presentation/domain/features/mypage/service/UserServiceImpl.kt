package com.findapple.presentation.domain.features.mypage.service

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.errorhandler.ErrorHandler
import com.findapple.presentation.domain.features.mypage.entity.User
import com.findapple.presentation.domain.features.mypage.repository.UserRepository
import com.findapple.presentation.domain.toResult
import io.reactivex.Single

class UserServiceImpl(
    private val repository: UserRepository,
    private val errorHandler: ErrorHandler
) : UserService {
    override fun getUserInfo(): Single<Result<User>> =
        repository.getUserInfo().toResult(errorHandler)
}