package com.findapple.findapple.domain.main.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.main.service.MainService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RefreshTokenUseCase(private val mainService: MainService, compositeDisposable: CompositeDisposable): UseCase<Unit, Result<Token>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<Token>> =
        mainService.refreshToken()
}