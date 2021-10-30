package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.data.base.ErrorHandlerImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
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