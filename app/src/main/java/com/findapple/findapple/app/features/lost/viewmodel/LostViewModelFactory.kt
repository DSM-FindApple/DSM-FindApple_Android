package com.findapple.findapple.app.features.lost.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.domain.main.repository.MainRepository

class LostViewModelFactory(private val getLostListUseCase: GetLostListUseCase, private val mainRepository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetLostListUseCase::class.java, MainRepository::class.java).newInstance(getLostListUseCase, mainRepository)
}