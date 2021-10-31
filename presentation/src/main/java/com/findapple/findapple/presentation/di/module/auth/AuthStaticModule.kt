package com.findapple.findapple.presentation.di.module.auth

import com.findapple.findapple.data.features.auth.datasource.AuthDataSource
import com.findapple.findapple.data.features.auth.datasource.AuthDataSourceImpl
import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.features.auth.repository.AuthRepositoryImpl
import com.findapple.findapple.data.local.database.dao.UserDao
import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.findapple.domain.features.auth.service.AuthService
import com.findapple.findapple.domain.features.auth.service.AuthServiceImpl
import com.findapple.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.findapple.presentation.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class AuthStaticModule {
    @FragmentScope
    @Provides
    fun provideLoginUseCase(
        authService: AuthService,
        compositeDisposable: CompositeDisposable
    ): LoginUseCase = LoginUseCase(authService, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideSaveUserUseCase(
        repository: AuthRepository,
        compositeDisposable: CompositeDisposable
    ): SaveUserUseCase = SaveUserUseCase(repository, compositeDisposable)

    @FragmentScope
    @Provides
    fun provideAuthService(
        authRepository: AuthRepository,
        errorHandler: ErrorHandler
    ): AuthService = AuthServiceImpl(authRepository, errorHandler)

    @FragmentScope
    @Provides
    fun provideAuthRepository(
        authDataSource: AuthDataSource,
        localStorage: LocalStorage
    ): AuthRepository = AuthRepositoryImpl(authDataSource, localStorage)

    @FragmentScope
    @Provides
    fun provideAuthDataSource(
        authApi: AuthApi,
        userDao: UserDao,
        localStorage: LocalStorage
    ): AuthDataSource = AuthDataSourceImpl(authApi, userDao, localStorage)
}