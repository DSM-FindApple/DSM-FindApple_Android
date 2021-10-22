package com.findapple.presentation.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.base.SingleLiveEvent

class LostViewModel(private val getLostListUseCase: GetLostListUseCase) : BaseViewModel() {

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    private val _startPostLost = SingleLiveEvent<Unit>()
    val startPostLost: LiveData<Unit> get() = _startPostLost

    override fun apply(event: Lifecycle.Event) {
    }

    fun startPost() {
        _startPostLost.call()
    }
}