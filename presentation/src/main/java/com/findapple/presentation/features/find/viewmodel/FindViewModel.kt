package com.findapple.presentation.features.find.viewmodel

import androidx.lifecycle.Lifecycle
import com.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.presentation.base.BaseViewModel

class FindViewModel(private val getFindListUseCase: GetFindListUseCase) : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE->{

            }
        }
    }
}