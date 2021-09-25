package com.findapple.presentation.features.lost.viewmodel

import com.findapple.presentation.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.base.BaseViewModel

class LostViewModel(private val getLostListUseCase: GetLostListUseCase): BaseViewModel() {
}