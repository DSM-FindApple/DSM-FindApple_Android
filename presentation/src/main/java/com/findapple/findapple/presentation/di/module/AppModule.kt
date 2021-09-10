package com.findapple.findapple.presentation.di.module

import android.app.Application
import android.content.Context
import com.findapple.findapple.presentation.di.app.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: BaseApp): Application = app
}