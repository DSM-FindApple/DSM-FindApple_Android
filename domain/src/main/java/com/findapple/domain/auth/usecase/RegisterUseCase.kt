package com.findapple.domain.auth.usecase

import com.findapple.domain.auth.`object`.RegisterObject
import com.findapple.domain.auth.entity.Auth
import com.findapple.domain.auth.service.AuthService
import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RegisterUseCase(
    private val authService: AuthService,
    compositeDisposable: CompositeDisposable
) : UseCase<RegisterObject, Result<Unit>>(compositeDisposable) {
    override fun create(data: RegisterObject): Single<Result<Unit>> =
        authService.register(data)
}