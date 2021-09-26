package com.findapple.domain.features.mypage.usecase

import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.mypage.service.UserService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserUseCase(private val service: UserService, compositeDisposable: CompositeDisposable) :
    UseCase<Unit, Result<User>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<User>> =
        service.getUserInfo()
}