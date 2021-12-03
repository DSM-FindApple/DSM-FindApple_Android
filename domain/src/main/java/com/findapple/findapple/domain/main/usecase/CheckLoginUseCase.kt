package com.findapple.findapple.domain.main.usecase

import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class CheckLoginUseCase(
    private val mainRepository: MainRepository,
    compositeDisposable: CompositeDisposable
) : UseCase<Unit, String>(compositeDisposable) {
    override fun create(data: Unit): Single<String> =
        mainRepository.checkLogin()
}