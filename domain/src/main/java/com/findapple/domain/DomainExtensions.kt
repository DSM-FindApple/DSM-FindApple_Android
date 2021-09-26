package com.findapple.domain

import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.base.Result
import io.reactivex.Single

fun <T> Single<T>.toResult(handler: ErrorHandler): Single<Result<T>> =
    this.map { Result.Success(it) as Result<T> }.onErrorReturn { Result.Failure(handler.getError(it)) }