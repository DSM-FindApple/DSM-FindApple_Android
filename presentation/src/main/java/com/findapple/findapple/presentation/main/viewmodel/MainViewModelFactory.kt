package com.findapple.findapple.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.main.usecase.CheckLoginUseCase

class MainViewModelFactory(private val checkLoginUseCase: CheckLoginUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(CheckLoginUseCase::class.java).newInstance(checkLoginUseCase)
}