package com.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.mypage.usecase.GetUserUseCase

class MyPageViewModelFactory(private val getUserUseCase: GetUserUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetUserUseCase::class.java).newInstance(getUserUseCase)
}