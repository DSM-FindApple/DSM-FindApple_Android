package com.findapple.findapple.app.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.MultipleRecyclerViewItem
import com.findapple.findapple.app.features.chat.ChatRoomData
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.app.features.post.viewModel.toRecyclerItem
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LostViewModel(
    private val getLostListUseCase: GetLostListUseCase,
    private val mainRepository: MainRepository
) : BasePostViewModel() {

    override val postService: PostService = getLostListUseCase.postService
    val lostList = MutableLiveData<List<MultipleRecyclerViewItem>>()

    private val _startPostLost = SingleLiveEvent<Unit>()
    val startPostLost: LiveData<Unit> get() = _startPostLost

    private val _startChatInfo = SingleLiveEvent<ChatRoomData>()
    val startChatInfo: LiveData<ChatRoomData> get() = _startChatInfo

    private val _showLocationInfo = SingleLiveEvent<Location>()
    val showLocationInfo: LiveData<Location> get() = _showLocationInfo

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                lostList.value = null
                page.value = 0
                getUserId()
            }
        }
    }

    private fun getUserId() {
        userId = mainRepository.getUserId()
    }

    override fun getPosts() {
        getLostListUseCase.execute(
            GetPostParameter(page.value ?: 0, location),
            object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        val addItem: ArrayList<MultipleRecyclerViewItem> =
                            if (lostList.value != null) lostList.value as ArrayList<MultipleRecyclerViewItem> else ArrayList()
                        lostList.value = addItem.apply {
                            addAll(t.value.map {
                                PostItemViewModel(
                                    it,
                                    this@LostViewModel
                                ).toRecyclerItem(it.user.id == userId)
                            })
                        }

                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }


    fun startPost() {
        _startPostLost.call()
    }

    override fun showMap(post: Post) {
        _showLocationInfo.value = Location(post.location.longitude, post.location.latitude)
    }

    override fun startChatting(post: Post) {
        mainRepository.getChatRoomId(post.user.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
            if(response is Result.Success) {
                _startChatInfo.value = ChatRoomData(response.value, post)
            }
        }
    }
}