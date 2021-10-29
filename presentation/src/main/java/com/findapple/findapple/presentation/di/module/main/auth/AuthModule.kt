package com.findapple.findapple.presentation.di.module.main.auth

import com.findapple.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
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