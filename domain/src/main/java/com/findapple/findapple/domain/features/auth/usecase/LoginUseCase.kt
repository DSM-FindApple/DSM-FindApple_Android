package com.findapple.findapple.domain.features.auth.usecase

import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.features.auth.service.AuthService
import com.findapple.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.auth.parameter.LoginParameter

class LoginUseCase(private val authService: AuthService, compositeDisposable: CompositeDisposable) :
    UseCase<LoginParameter, Result<Token>>(compositeDisposable) {
    override fun create(data: LoginParameter): Single<Result<Token>> = authService.login(data)
}