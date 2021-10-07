package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.auth.usecase.LoginUseCase

class AuthViewModelFactory(
    private val loginUseCase: LoginUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(LoginUseCase::class.java)
            .newInstance(loginUseCase)
}