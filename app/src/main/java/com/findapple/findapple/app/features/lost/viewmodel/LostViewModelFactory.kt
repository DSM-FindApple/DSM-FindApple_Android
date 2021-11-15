package com.findapple.findapple.app.features.lost.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase

class LostViewModelFactory(private val getLostListUseCase: GetLostListUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetLostListUseCase::class.java).newInstance(getLostListUseCase)
}