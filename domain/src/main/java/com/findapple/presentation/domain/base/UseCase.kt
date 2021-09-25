package com.findapple.presentation.domain.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, E>(private val composite: CompositeDisposable) {

    abstract fun create(data: T): Single<E>

    fun execute(data: T, singleObserver: DisposableSingleObserver<E>, scheduler: Scheduler) {
        val observer =
            create(data)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribeWith(singleObserver)

        composite.add(observer)
    }

    fun clear() = composite.clear()
}