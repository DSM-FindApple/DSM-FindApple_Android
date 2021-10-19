package com.findapple.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.main.MainFragment
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
        mainFragment: MainFragment
    ): MainViewModel = ViewModelProvider(mainFragment, mainViewModelFactory).get(MainViewModel::class.java)

}