package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.presentation.di.scope.ActivityScope
import com.findapple.findapple.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}