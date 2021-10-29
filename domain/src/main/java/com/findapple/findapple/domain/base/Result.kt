package com.findapple.findapple.domain.base

import com.findapple.findapple.domain.errorhandler.Error

sealed class Result<T> {
    data class Success<T>(val value:T) : Result<T>()

    data class Failure<T>(val reason: Error) : Result<T>()
}
