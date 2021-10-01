package com.findapple.presentation.features.auth.viewmodel

import androidx.lifecycle.Lifecycle
import com.findapple.domain.features.auth.usecase.LoginUseCase
import com.findapple.domain.features.auth.usecase.RegisterUseCase
import com.findapple.presentation.base.BaseViewModel

class AuthViewModel(
    private val LoginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {

    }
}