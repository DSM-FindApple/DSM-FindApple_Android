package com.findapple.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.main.MainActivity
import com.findapple.presentation.main.viewmodel.MainViewModel
import com.findapple.presentation.main.viewmodel.MainViewModelFactory
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