package com.findapple.presentation.di.module

import com.findapple.data.local.database.Database
import com.findapple.data.local.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDao(
        database: Database
    ): UserDao =
        database.userDao
}