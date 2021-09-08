package com.findapple.domain.base

sealed class Result<T> {
    data class Success<T>(val value:T) : Result<T>()

    data class Failure<T>(val reason: Error) : Result<T>()
}
