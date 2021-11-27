package com.findapple.findapple.app.features.comment.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.domain.features.post.entity.Post

class CommentViewModel : BaseViewModel() {
    val post = MutableLiveData<Post>()
    override fun apply(event: Lifecycle.Event) {

    }
}