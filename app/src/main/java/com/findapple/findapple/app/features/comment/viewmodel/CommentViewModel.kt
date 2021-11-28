package com.findapple.findapple.app.features.comment.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.comment.parameter.GetCommentsParameter
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase
import com.findapple.findapple.domain.features.post.entity.Comment
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class CommentViewModel(private val getCommentsUseCase: GetCommentsUseCase) : BaseViewModel() {
    val post = MutableLiveData<Post>()

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> get() = _comments

    var postId: Long = 0
    var isLost = true

    override fun apply(event: Lifecycle.Event) {
        if(event == Lifecycle.Event.ON_CREATE) {
            loadComments()
        }
    }

    private fun loadComments() {
        getCommentsUseCase.execute(
            GetCommentsParameter(postId, isLost),
            object : DisposableSingleObserver<Result<List<Comment>>>() {
                override fun onSuccess(t: Result<List<Comment>>) {
                    if(t is Result.Success) {
                        _comments.value = t.value
                    }
                }

                override fun onError(e: Throwable) {

                }

            },
            AndroidSchedulers.mainThread()
        )
    }
}