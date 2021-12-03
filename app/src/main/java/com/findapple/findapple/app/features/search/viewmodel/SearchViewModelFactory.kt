package com.findapple.findapple.app.features.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.newInstance()
}