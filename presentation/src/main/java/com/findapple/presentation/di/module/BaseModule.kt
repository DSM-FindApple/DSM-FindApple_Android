package com.findapple.presentation.di.module

import com.findapple.presentation.data.base.ErrorHandlerImpl
import com.findapple.presentation.domain.errorhandler.ErrorHandler
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class BaseModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler = ErrorHandlerImpl()
}