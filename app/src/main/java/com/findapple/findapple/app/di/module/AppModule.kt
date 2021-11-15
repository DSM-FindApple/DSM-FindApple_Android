package com.findapple.findapple.app.di.module

import android.app.Application
import android.content.Context
import com.findapple.findapple.app.di.app.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        (NetWorkModule::class),
        (ApiModule::class),
        (LocalModule::class),
        (BaseModule::class),
        (DatabaseModule::class),
        (FCMServiceModule::class)
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: BaseApp): Application = app
}