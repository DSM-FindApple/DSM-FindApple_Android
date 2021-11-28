package com.findapple.findapple.app.features.comment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase
import com.findapple.findapple.domain.features.comment.usecase.PostCommentUseCase

class CommentViewModelFactory(private val getCommentsUseCase: GetCommentsUseCase, private val postCommentUseCase: PostCommentUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetCommentsUseCase::class.java, PostCommentUseCase::class.java).newInstance(getCommentsUseCase, postCommentUseCase)
}