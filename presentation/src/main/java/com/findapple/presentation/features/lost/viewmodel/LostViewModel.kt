package com.findapple.presentation.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.base.BaseViewModel

class LostViewModel(private val getLostListUseCase: GetLostListUseCase): BaseViewModel() {

    override fun apply(event: Lifecycle.Event) {
    }
}