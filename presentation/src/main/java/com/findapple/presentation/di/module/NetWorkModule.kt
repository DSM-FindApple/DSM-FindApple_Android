package com.findapple.presentation.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.findapple.data.base.Interceptor
import com.findapple.data.local.sharedpref.LocalStorage

@Module
class NetWorkModule {

    @Provides
    @Singleton
    fun provideInterceptor(localStorage: LocalStorage): Interceptor = Interceptor(localStorage)
}