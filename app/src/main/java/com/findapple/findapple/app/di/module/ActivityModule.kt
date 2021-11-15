package com.findapple.findapple.app.di.module

import com.findapple.findapple.app.di.scope.ActivityScope
import com.findapple.findapple.app.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}