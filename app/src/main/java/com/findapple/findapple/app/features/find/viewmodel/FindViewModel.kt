package com.findapple.findapple.app.features.find.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.app.base.SingleLiveEvent

class FindViewModel(private val getFindListUseCase: GetFindListUseCase) : BaseViewModel() {

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    val startPostFind = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE->{

            }
        }
    }

    fun startPostFind(){
        startPostFind.call()
    }
}