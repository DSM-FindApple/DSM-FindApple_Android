package com.findapple.presentation.di.module

import com.findapple.presentation.di.module.main.MainModule
import com.findapple.presentation.di.module.main.auth.AuthModule
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.features.auth.AuthFragment
import com.findapple.presentation.features.splash.SplashFragment
import com.findapple.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class])
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AuthModule::class])
    abstract fun authFragment(): AuthFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment
}