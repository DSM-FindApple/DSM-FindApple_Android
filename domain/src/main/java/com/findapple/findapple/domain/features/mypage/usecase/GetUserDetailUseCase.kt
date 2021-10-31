package com.findapple.findapple.domain.features.mypage.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.mypage.service.UserService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserDetailUseCase(
    private val service: UserService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, Result<UserDetail>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<UserDetail>> =
        service.getUserDetail()
}