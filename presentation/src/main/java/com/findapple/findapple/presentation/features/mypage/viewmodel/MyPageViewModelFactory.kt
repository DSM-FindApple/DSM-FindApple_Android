package com.findapple.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase

class MyPageViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val getUserDetailUseCase: GetUserDetailUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetUserUseCase::class.java, GetUserDetailUseCase::class.java)
            .newInstance(getUserUseCase, getUserDetailUseCase)
}