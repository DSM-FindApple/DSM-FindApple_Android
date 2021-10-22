package com.findapple.presentation.di.module

import com.findapple.presentation.di.module.main.MainModule
import com.findapple.presentation.di.module.auth.AuthModule
import com.findapple.presentation.di.module.auth.AuthStaticModule
import com.findapple.presentation.di.module.main.post.PostStaticModule
import com.findapple.presentation.di.module.post.find.PostFindModule
import com.findapple.presentation.di.module.post.find.PostFindStaticModule
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.features.auth.AuthFragment
import com.findapple.presentation.features.post.PostFindFragment
import com.findapple.presentation.features.splash.SplashFragment
import com.findapple.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class, PostStaticModule::class])
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AuthModule::class, AuthStaticModule::class])
    abstract fun authFragment(): AuthFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostFindModule::class, PostFindStaticModule::class, PostStaticModule::class])
    abstract fun postFindFragment(): PostFindFragment
}