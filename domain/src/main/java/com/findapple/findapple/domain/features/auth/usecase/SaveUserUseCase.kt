package com.findapple.findapple.domain.features.auth.usecase

import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.auth.repository.AuthRepository
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