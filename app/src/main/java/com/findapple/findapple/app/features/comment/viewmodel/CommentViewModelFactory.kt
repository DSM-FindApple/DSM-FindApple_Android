package com.findapple.findapple.app.features.comment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase

class CommentViewModelFactory(private val getCommentsUseCase: GetCommentsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetCommentsUseCase::class.java).newInstance(getCommentsUseCase)
}