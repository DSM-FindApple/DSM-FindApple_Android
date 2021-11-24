package com.findapple.findapple.domain.features.mypage.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.toResult
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserServiceImpl(
    private val repository: UserRepository,
    private val errorHandler: ErrorHandler
) : UserService {
    override fun getUserDetail(): Single<Result<UserDetail>> =
        repository.getUserDetail().toResult(errorHandler)

    override fun logout(): Single<Result<Unit>> =
        repository.logout().toResult(errorHandler)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}