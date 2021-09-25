package com.findapple.presentation.domain.errorhandler

interface ErrorHandler {
    fun getError(throwable: Throwable): Error
}