package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.data.local.database.Database
import com.findapple.findapple.data.local.database.dao.UserDao
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