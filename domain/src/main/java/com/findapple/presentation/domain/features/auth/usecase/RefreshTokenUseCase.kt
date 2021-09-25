package com.findapple.presentation.domain.features.auth.usecase

import com.findapple.presentation.domain.features.auth.service.AuthService
import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RefreshTokenUseCase(private val authService: AuthService,compositeDisposable: CompositeDisposable): UseCase<Unit,Result<Unit>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<Unit>> =
        authService.refreshToken()
}