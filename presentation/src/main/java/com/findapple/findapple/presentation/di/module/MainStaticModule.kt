package com.findapple.findapple.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.main.MainActivity
import com.findapple.findapple.presentation.main.viewmodel.MainViewModel
import com.findapple.findapple.presentation.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainStaticModule {
    @FragmentScope
    @Provides
    fun provideMainViewModelFactory(): MainViewModelFactory = MainViewModelFactory()

    @FragmentScope
    @Provides
    fun provideMainViewModel(
        mainViewModelFactory: MainViewModelFactory,
        mainActivity: MainActivity
    ): MainViewModel =
        ViewModelProvider(mainActivity, mainViewModelFactory).get(MainViewModel::class.java)

}