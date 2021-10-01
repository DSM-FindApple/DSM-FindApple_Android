package com.findapple.presentation.di.module.main.auth

import com.findapple.data.features.auth.datasource.AuthDataSource
import com.findapple.data.features.auth.datasource.AuthDataSourceImpl
import com.findapple.data.features.auth.remote.AuthApi
import com.findapple.data.features.auth.repository.AuthRepositoryImpl
import com.findapple.data.local.sharedpref.LocalStorage
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.domain.features.auth.service.AuthService
import com.findapple.domain.features.auth.service.AuthServiceImpl
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.RegisterUseCase
import com.findapple.presentation.di.scope.FragmentScope
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
    fun provideRegisterUseCase(
        authService: AuthService,
        compositeDisposable: CompositeDisposable
    ): RegisterUseCase = RegisterUseCase(authService, compositeDisposable)

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
    ): AuthRepository = AuthRepositoryImpl(authDataSource,localStorage)

    @FragmentScope
    @Provides
    fun provideAuthDataSource(
        authApi: AuthApi
    ): AuthDataSource = AuthDataSourceImpl(authApi)
}