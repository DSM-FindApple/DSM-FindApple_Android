package com.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.domain.features.post.usecase.GetUserPostListUseCase

class MyPageViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val getUserPostListUseCase: GetUserPostListUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetUserUseCase::class.java, GetUserPostListUseCase::class.java)
            .newInstance(getUserUseCase, getUserPostListUseCase)
}