package com.findapple.presentation.domain.features.auth.usecase

import com.findapple.presentation.domain.features.auth.`object`.RegisterObject
import com.findapple.presentation.domain.features.auth.service.AuthService
import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RegisterUseCase(
    private val authService: AuthService,
    compositeDisposable: CompositeDisposable
) : UseCase<RegisterObject, Result<Unit>>(compositeDisposable) {
    override fun create(data: RegisterObject): Single<Result<Unit>> =
        authService.register(data)
}