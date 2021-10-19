package com.findapple.presentation.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.base.BaseViewModel

class LostViewModel(private val getLostListUseCase: GetLostListUseCase): BaseViewModel() {

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {
    }
}