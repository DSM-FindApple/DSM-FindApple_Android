package com.findapple.domain.auth.usecase

import com.findapple.domain.auth.request.RegisterRequest
import com.findapple.domain.auth.service.AuthService
import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RegisterUseCase(
    private val authService: AuthService,
    compositeDisposable: CompositeDisposable
) : UseCase<RegisterRequest, Result<Unit>>(compositeDisposable) {
    override fun create(data: RegisterRequest): Single<Result<Unit>> =
        authService.register(data)
}