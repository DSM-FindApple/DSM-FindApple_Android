package com.findapple.findapple.domain.main.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RefreshTokenUseCase(compositeDisposable: CompositeDisposable): UseCase<Unit, Result<Unit>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<Unit>> {
        TODO("Not yet implemented")
    }
}