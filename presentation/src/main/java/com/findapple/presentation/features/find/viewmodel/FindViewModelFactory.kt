package com.findapple.presentation.features.find.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.domain.features.post.usecase.GetFindListUseCase

class FindViewModelFactory(private val getFindListUseCase: GetFindListUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetFindListUseCase::class.java).newInstance(getFindListUseCase)
}