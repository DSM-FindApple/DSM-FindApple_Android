package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun mainFragment(): MainFragment
}