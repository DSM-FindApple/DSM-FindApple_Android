package com.findapple.findapple.presentation.main.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.presentation.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    val location = MutableLiveData(Location(127.3635946, 36.3914388))
    override fun apply(event: Lifecycle.Event) {
    }
}