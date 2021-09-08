package com.findapple.domain.auth.usecase

import com.findapple.domain.auth.request.LoginRequest
import com.findapple.domain.auth.response.LoginResponse
import com.findapple.domain.auth.service.AuthService
import com.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.findapple.domain.base.Result

class LoginUseCase(private val authService: AuthService, compositeDisposable: CompositeDisposable) :
    UseCase<LoginRequest, Result<LoginResponse>>(compositeDisposable) {
    override fun create(data: LoginRequest): Single<Result<LoginResponse>> = authService.login(data)
}