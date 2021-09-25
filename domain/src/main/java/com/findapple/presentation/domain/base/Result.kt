package com.findapple.presentation.domain.base

import com.findapple.presentation.domain.errorhandler.Error

sealed class Result<T> {
    data class Success<T>(val value:T) : Result<T>()

    data class Failure<T>(val reason: Error) : Result<T>()
}
