package com.findapple.findapple.domain.auth.usecase

import com.findapple.findapple.domain.auth.service.AuthService
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RefreshTokenUseCase(private val authService: AuthService,compositeDisposable: CompositeDisposable): UseCase<Unit,Result<Unit>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<Unit>> =
        authService.refreshToken()
}