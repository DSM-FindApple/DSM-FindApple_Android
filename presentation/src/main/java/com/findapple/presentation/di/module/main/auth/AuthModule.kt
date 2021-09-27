package com.findapple.presentation.di.module.main.auth

import com.findapple.presentation.di.scope.FragmentScope
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AuthModule {
    @FragmentScope
    @Provides
    fun provideAuthViewModelFactory(): AuthViewModelFactory = AuthViewModelFactory()
}