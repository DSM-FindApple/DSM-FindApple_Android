package com.findapple.presentation.di.module

import com.findapple.presentation.di.scope.ActivityScope
import com.findapple.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}