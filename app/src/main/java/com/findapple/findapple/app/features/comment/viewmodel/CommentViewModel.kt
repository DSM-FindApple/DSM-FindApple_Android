package com.findapple.findapple.app.features.comment.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.BR
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.comment.parameter.GetCommentsParameter
import com.findapple.findapple.domain.features.comment.parameter.PostCommentParameter
import com.findapple.findapple.domain.features.comment.usecase.GetCommentsUseCase
import com.findapple.findapple.domain.features.comment.usecase.PostCommentUseCase
import com.findapple.findapple.domain.features.post.entity.Comment
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class CommentViewModel(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val postCommentUseCase: PostCommentUseCase
) : BaseViewModel() {
    val post = MutableLiveData<Post>()

    private val _comments = MutableLiveData<List<RecyclerViewItem>>()
    val comments: LiveData<List<RecyclerViewItem>> get() = _comments

    var postId: Long = 0
    var isLost = true

    val comment = MutableLiveData<String>()

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
                        _comments.value = t.value.map { it.toRecyclerViewItem() }
                    }
                }

                override fun onError(e: Throwable) {

                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    fun sendComment() {
        if(!comment.value.isNullOrBlank()) {
            postCommentUseCase.execute(
                PostCommentParameter(postId, comment.value!!, isLost),
                object : DisposableSingleObserver<Result<Unit>>() {
                    override fun onSuccess(t: Result<Unit>) {
                        if(t is Result.Success) {
                            comment.value = null
                            loadComments()
                        }
                    }

                    override fun onError(e: Throwable) {
                    }

                },
                AndroidSchedulers.mainThread()
            )
        }

    }

    private fun Comment.toRecyclerViewItem() =
        RecyclerViewItem(
            data = this,
            variableId = BR.comment,
            itemLayoutId = R.layout.item_comment
        )
}