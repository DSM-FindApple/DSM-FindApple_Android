package com.findapple.domain.features.mypage.usecase

import com.findapple.domain.base.UseCase
import com.findapple.domain.features.mypage.entity.User
import com.findapple.domain.features.mypage.repository.UserRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserUseCase(
    private val service: UserRepository,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, User>(compositeDisposable) {
    override fun create(data: Unit): Single<User> =
        service.getUserInfo()
}