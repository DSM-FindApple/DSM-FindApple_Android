package com.findapple.findapple.app.di.module.main

import com.findapple.findapple.app.di.module.MainStaticModule
import com.findapple.findapple.app.di.module.main.chatting.ChattingModule
import com.findapple.findapple.app.di.module.main.mypage.MyPageModule
import com.findapple.findapple.app.di.module.main.mypage.MyPageStaticModule
import com.findapple.findapple.app.di.module.main.post.find.FindModule
import com.findapple.findapple.app.di.module.main.post.lost.LostModule
import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.app.features.chat.ChattingFragment
import com.findapple.findapple.app.features.find.FindFragment
import com.findapple.findapple.app.features.lost.LostFragment
import com.findapple.findapple.app.features.mypage.MyPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @MainFragmentScope
    @ContributesAndroidInjector(modules = [LostModule::class])
    abstract fun lostFragment(): LostFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [FindModule::class])
    abstract fun findFragment(): FindFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [ChattingModule::class])
    abstract fun chattingFragment(): ChattingFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [MyPageModule::class, MyPageStaticModule::class])
    abstract fun mypageFragment(): MyPageFragment
}