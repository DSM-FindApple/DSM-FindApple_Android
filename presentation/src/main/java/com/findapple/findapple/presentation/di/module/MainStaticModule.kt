package com.findapple.findapple.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.data.local.sharedpref.LocalStorage
import com.findapple.findapple.data.main.datasource.MainDataSource
import com.findapple.findapple.data.main.datasource.MainDataSourceImpl
import com.findapple.findapple.data.main.repository.MainRepositoryImpl
import com.findapple.findapple.domain.main.repository.MainRepository
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.main.MainActivity
import com.findapple.findapple.presentation.main.viewmodel.MainViewModel
import com.findapple.findapple.presentation.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainStaticModule {
    @FragmentScope
    @Provides
    fun provideMainViewModelFactory(checkLoginUseCase: CheckLoginUseCase): MainViewModelFactory =
        MainViewModelFactory(checkLoginUseCase)

    @FragmentScope
    @Provides
    fun provideMainViewModel(
        mainViewModelFactory: MainViewModelFactory,
        mainActivity: MainActivity
    ): MainViewModel =
        ViewModelProvider(mainActivity, mainViewModelFactory).get(MainViewModel::class.java)

    @FragmentScope
    @Provides
    fun provideCheckLoginUseCase(
        mainRepository: MainRepository,
        compositeDisposable: CompositeDisposable
    ): CheckLoginUseCase = CheckLoginUseCase(mainRepository, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideMainRepository(
        datasource: MainDataSource
    ): MainRepository = MainRepositoryImpl(datasource)

    @FragmentScope
    @Provides
    fun provideMainDatasource(
        localStorage: LocalStorage
    ): MainDataSource = MainDataSourceImpl(localStorage)
}