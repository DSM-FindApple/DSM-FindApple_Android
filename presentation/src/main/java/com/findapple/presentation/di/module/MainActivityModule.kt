package com.findapple.presentation.di.module

import com.findapple.presentation.di.module.main.MainModule
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainFragment(): MainFragment
}