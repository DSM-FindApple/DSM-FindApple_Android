package com.findapple.findapple.app.features.find.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.domain.main.repository.MainRepository

class FindViewModelFactory(private val getFindListUseCase: GetFindListUseCase, private val mainRepository: MainRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetFindListUseCase::class.java, MainRepository::class.java).newInstance(getFindListUseCase, mainRepository)
}