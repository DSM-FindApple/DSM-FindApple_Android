package com.findapple.findapple.domain.lost.usecase

import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.lost.entity.LostFindListData
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetLostListUseCase(compositeDisposable: CompositeDisposable) :
    UseCase<Unit, LostFindListData>(compositeDisposable) {
    override fun create(data: Unit): Single<LostFindListData> {
        TODO("Not yet implemented")
    }
}