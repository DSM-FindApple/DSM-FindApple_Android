package com.findapple.domain.features.auth.usecase

import com.findapple.domain.base.UseCase
import com.findapple.domain.entity.User
import com.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.domain.features.mypage.repository.UserRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SaveUserUseCase(
    private val repository: AuthRepository,
    compositeDisposable: CompositeDisposable
) :
    UseCase<User, Unit>(compositeDisposable) {
    override fun create(data: User): Single<Unit> =
        repository.saveUserInfo(data)

}