package com.findapple.findapple.domain.errorhandler

interface ErrorHandler {
    fun getError(throwable: Throwable): Error
}