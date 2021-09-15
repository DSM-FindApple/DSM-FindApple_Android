package com.findapple.findapple.presentation.features.lost.viewmodel

import com.findapple.findapple.domain.post.usecase.GetLostListUseCase
import com.findapple.findapple.presentation.base.BaseViewModel

class LostViewModel(private val getLostListUseCase: GetLostListUseCase): BaseViewModel() {
}