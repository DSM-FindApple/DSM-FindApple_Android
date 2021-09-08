package com.findapple.domain.auth.usecase

import com.findapple.domain.auth.request.LoginRequest
import com.findapple.domain.auth.response.LoginResponse
import com.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class LoginUseCase(compositeDisposable: CompositeDisposable) :
    UseCase<LoginRequest, LoginResponse>(compositeDisposable) {
    override fun create(data: LoginRequest): Single<LoginResponse> {
        TODO("Not yet implemented")
    }
}