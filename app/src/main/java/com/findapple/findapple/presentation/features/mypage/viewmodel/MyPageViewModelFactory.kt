package com.findapple.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserPostListUseCase

class MyPageViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val getUserPostListUseCase: GetUserPostListUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetUserUseCase::class.java, GetUserPostListUseCase::class.java)
            .newInstance(getUserUseCase, getUserPostListUseCase)
}