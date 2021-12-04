package com.findapple.findapple.app.di.module

import com.findapple.findapple.app.di.module.main.MainModule
import com.findapple.findapple.app.di.module.auth.AuthModule
import com.findapple.findapple.app.di.module.auth.AuthStaticModule
import com.findapple.findapple.app.di.module.comment.CommentModule
import com.findapple.findapple.app.di.module.comment.CommentStaticModule
import com.findapple.findapple.app.di.module.main.chatting.ChatDetailModule
import com.findapple.findapple.app.di.module.main.post.PostStaticModule
import com.findapple.findapple.app.di.module.main.search.SearchModule
import com.findapple.findapple.app.di.module.post.PostModule
import com.findapple.findapple.app.di.module.post.PostUseCaseModule
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.auth.AuthFragment
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment
import com.findapple.findapple.app.features.comment.fragment.CommentFragment
import com.findapple.findapple.app.features.post.PostFragment
import com.findapple.findapple.app.features.search.SearchFragment
import com.findapple.findapple.app.features.splash.SplashFragment
import com.findapple.findapple.app.main.MainFragment
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
    @ContributesAndroidInjector(modules = [PostModule::class, PostUseCaseModule::class, PostStaticModule::class, MainStaticModule::class])
    abstract fun postFragment(): PostFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ChatDetailModule::class, MainStaticModule::class])
    abstract fun chatDetailFragment(): ChatDetailFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CommentModule::class, CommentStaticModule::class])
    abstract fun commentFragment(): CommentFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun searchFragment(): SearchFragment
}