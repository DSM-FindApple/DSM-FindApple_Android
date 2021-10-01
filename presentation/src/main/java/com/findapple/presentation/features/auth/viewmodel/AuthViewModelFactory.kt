package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.RegisterUseCase

class AuthViewModelFactory(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(LoginUseCase::class.java, RegisterUseCase::class.java)
            .newInstance(loginUseCase, registerUseCase)
}