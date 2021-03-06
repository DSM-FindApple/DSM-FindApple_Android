package com.findapple.findapple.app.di.module

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.app.di.scope.ActivityScope
import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.data.main.datasource.MainDataSource
import com.findapple.findapple.data.main.datasource.MainDataSourceImpl
import com.findapple.findapple.data.main.repository.MainRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.main.repository.MainRepository
import com.findapple.findapple.domain.main.service.MainService
import com.findapple.findapple.domain.main.service.MainServiceImpl
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase
import com.findapple.findapple.domain.main.usecase.RefreshTokenUseCase
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.main.MainActivity
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import com.findapple.findapple.app.main.viewmodel.MainViewModelFactory
import com.findapple.findapple.data.features.chat.ChatApi
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainStaticModule {
    @ActivityScope
    @Provides
    fun provideMainViewModelFactory(
        checkLoginUseCase: CheckLoginUseCase,
        refreshTokenUseCase: RefreshTokenUseCase
    ): MainViewModelFactory =
        MainViewModelFactory(checkLoginUseCase, refreshTokenUseCase)

    @ActivityScope
    @Provides
    fun provideMainViewModel(
        mainViewModelFactory: MainViewModelFactory,
        mainActivity: MainActivity
    ): MainViewModel =
        ViewModelProvider(mainActivity, mainViewModelFactory).get(MainViewModel::class.java)

    @ActivityScope
    @Provides
    fun provideCheckLoginUseCase(
        mainRepository: MainRepository,
        compositeDisposable: CompositeDisposable
    ): CheckLoginUseCase = CheckLoginUseCase(mainRepository, compositeDisposable)

    @ActivityScope
    @Provides
    fun provideRefreshTokenUseCase(
        mainService: MainService,
        compositeDisposable: CompositeDisposable
    ): RefreshTokenUseCase = RefreshTokenUseCase(mainService, compositeDisposable)

    @ActivityScope
    @Provides
    fun provideMainRepository(
        datasource: MainDataSource,
        errorHandler: ErrorHandler
    ): MainRepository = MainRepositoryImpl(datasource, errorHandler)

    @ActivityScope
    @Provides
    fun provideMainService(
        repository: MainRepository,
        errorHandler: ErrorHandler
    ): MainService = MainServiceImpl(repository, errorHandler)

    @ActivityScope
    @Provides
    fun provideMainDatasource(
        localStorage: LocalStorage,
        authApi: AuthApi,
        chatApi: ChatApi
    ): MainDataSource = MainDataSourceImpl(localStorage, authApi, chatApi)
}