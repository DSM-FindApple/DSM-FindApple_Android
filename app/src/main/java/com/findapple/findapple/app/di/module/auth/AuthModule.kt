package com.findapple.findapple.app.di.module.auth

import com.findapple.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.auth.viewmodel.AuthViewModelFactory
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