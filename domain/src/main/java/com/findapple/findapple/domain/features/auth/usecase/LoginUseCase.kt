package com.findapple.findapple.domain.features.auth.usecase

import com.findapple.findapple.domain.features.auth.entity.Auth
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.features.auth.service.AuthService
import com.findapple.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.findapple.findapple.domain.base.Result

class LoginUseCase(private val authService: AuthService, compositeDisposable: CompositeDisposable) :
    UseCase<Auth, Result<Token>>(compositeDisposable) {
    override fun create(data: Auth): Single<Result<Token>> = authService.login(data)
}