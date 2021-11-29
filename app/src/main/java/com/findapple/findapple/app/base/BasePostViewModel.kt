package com.findapple.findapple.app.base

import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.entity.Location

abstract class BasePostViewModel: BaseViewModel() {

    var userId: Long = -1

    val page = MutableLiveData<Int>()

    var location = Location(127.3635946, 36.3914388)

    val clickedCommentId = SingleLiveEvent<Long>()

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    val moreClickedPostId = SingleLiveEvent<Long>()

    fun commentClicked(id: Long) {
        clickedCommentId.value = id
    }

    fun moreClicked(id: Long) {
        moreClickedPostId.value = id
    }

    fun showMap() {

    }
}