package com.findapple.findapple.domain

import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.base.Result
import io.reactivex.Single

fun <T : Any> Single<T>.toResult(handler: ErrorHandler): Single<Result<T>> =
    this.map { data -> Result.Success(data) as Result<T> }
        .onErrorReturn { error -> Result.Failure(handler.getError(error)) }