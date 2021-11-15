package com.findapple.findapple.app.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase
import com.findapple.findapple.domain.main.usecase.RefreshTokenUseCase

class MainViewModelFactory(private val checkLoginUseCase: CheckLoginUseCase, private val refreshTokenUseCase: RefreshTokenUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(CheckLoginUseCase::class.java, RefreshTokenUseCase::class.java).newInstance(checkLoginUseCase, refreshTokenUseCase)
}