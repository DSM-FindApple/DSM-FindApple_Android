package com.findapple.presentation.di.module

import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainStaticModule {
    @FragmentScope
    @Provides
    fun provideMainViewModelFactory(): MainViewModelFactory = MainViewModelFactory()
}