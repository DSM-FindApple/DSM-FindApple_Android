package com.findapple.presentation.di.module.auth

import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AuthModule {
    @FragmentScope
    @Provides
    fun provideAuthViewModelFactory(
        loginUseCase: LoginUseCase,
        saveUserUseCase: SaveUserUseCase
    ): AuthViewModelFactory = AuthViewModelFactory(loginUseCase, saveUserUseCase)
}