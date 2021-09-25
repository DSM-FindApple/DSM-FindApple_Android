package com.findapple.presentation.features.find.viewmodel

import com.findapple.presentation.domain.features.post.usecase.GetFindListUseCase
import com.findapple.presentation.base.BaseViewModel

class FindViewModel(private val getFindListUseCase: GetFindListUseCase) : BaseViewModel() {
}