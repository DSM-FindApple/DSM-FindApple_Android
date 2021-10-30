package com.findapple.findapple.presentation.di.module

import android.content.Context
import androidx.room.Room
import com.findapple.findapple.data.local.database.Database
import com.findapple.findapple.data.local.sharedpref.LocalStorage
import com.findapple.findapple.data.local.sharedpref.SharedPreferStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {
    @Provides
    @Singleton
    fun provideLocalStorage(context: Context): LocalStorage = SharedPreferStorage(context)

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "findapple.db").build()
}