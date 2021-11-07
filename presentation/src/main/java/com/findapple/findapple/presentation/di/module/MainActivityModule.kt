package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.presentation.di.module.main.MainModule
import com.findapple.findapple.presentation.di.module.auth.AuthModule
import com.findapple.findapple.presentation.di.module.auth.AuthStaticModule
import com.findapple.findapple.presentation.di.module.main.post.PostStaticModule
import com.findapple.findapple.presentation.di.module.post.PostFindModule
import com.findapple.findapple.presentation.di.module.post.PostUseCaseModule
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.features.auth.AuthFragment
import com.findapple.findapple.presentation.features.chat.ChatDetailFragment
import com.findapple.findapple.presentation.features.post.PostFragment
import com.findapple.findapple.presentation.features.splash.SplashFragment
import com.findapple.findapple.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class, PostStaticModule::class])
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AuthModule::class, AuthStaticModule::class, MainStaticModule::class])
    abstract fun authFragment(): AuthFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostFindModule::class, PostUseCaseModule::class, PostStaticModule::class])
    abstract fun postFragment(): PostFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun chatDetailFragment(): ChatDetailFragment
}