package com.findapple.findapple.app.base

import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.service.PostService

abstract class BasePostViewModel : BaseViewModel() {

    abstract fun getPosts()

    abstract val postService: PostService
    var userId: Long = -1

    val page = MutableLiveData<Int>()

    var location = Location(127.363, 36.391)

    val clickedCommentId = SingleLiveEvent<Long>()

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    val moreClickedPostId = SingleLiveEvent<Post>()

    fun commentClicked(id: Long) {
        clickedCommentId.value = id
    }

    fun moreClicked(post: Post) {
        moreClickedPostId.value = post
    }

    open fun showMap(post: Post) {}

    open fun startChatting(post: Post) {}

    fun deletePost(post: Post) {
        postService.deletePost(post, post.isLost).subscribe { result ->
            if (result is Result.Success) {
                page.value = 0
                getPosts()
            }
        }
    }
}