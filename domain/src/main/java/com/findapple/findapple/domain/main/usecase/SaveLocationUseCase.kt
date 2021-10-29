package com.findapple.findapple.domain.main.usecase

import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.entity.Location
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SaveLocationUseCase(compositeDisposable: CompositeDisposable) :
    UseCase<Location, Unit>(compositeDisposable) {

    override fun create(data: Location): Single<Unit> {
        TODO("Not yet implemented")
    }
}