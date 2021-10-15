package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.SaveUserUseCase

class AuthViewModelFactory(
    private val loginUseCase: LoginUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(LoginUseCase::class.java, SaveUserUseCase::class.java)
            .newInstance(loginUseCase, saveUserUseCase)
}