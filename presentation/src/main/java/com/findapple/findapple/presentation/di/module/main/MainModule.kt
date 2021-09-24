package com.findapple.findapple.presentation.di.module.main

import com.findapple.findapple.presentation.di.module.main.mypage.MyPageStaticModule
import com.findapple.findapple.presentation.di.module.main.post.PostStaticModule
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.presentation.features.chat.ChattingFragment
import com.findapple.findapple.presentation.features.find.FindFragment
import com.findapple.findapple.presentation.features.lost.LostFragment
import com.findapple.findapple.presentation.features.mypage.MyPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @MainFragmentScope
    @ContributesAndroidInjector(modules = [PostStaticModule::class])
    abstract fun lostFragment(): LostFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [PostStaticModule::class])
    abstract fun findFragment(): FindFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun chattingFragment(): ChattingFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [MyPageStaticModule::class])
    abstract fun mypageFragment(): MyPageFragment
}