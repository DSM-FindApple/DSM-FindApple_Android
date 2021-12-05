package com.findapple.findapple.app.features.find.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.MultipleRecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.app.features.post.viewModel.toRecyclerItem
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class FindViewModel(
    private val getFindListUseCase: GetFindListUseCase,
    private val mainRepository: MainRepository
) : BasePostViewModel() {

    override val postService: PostService
        get() = getFindListUseCase.postService
    val findList = MutableLiveData<List<MultipleRecyclerViewItem>>(mutableListOf())

    private val _startChatInfo = SingleLiveEvent<Post>()
    val startChatInfo: LiveData<Post> get() = _startChatInfo

    private val _showMapInfo = SingleLiveEvent<Location>()
    val showMapInfo: LiveData<Location> get() = _showMapInfo

    val startPostFind = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                findList.value = null
                page.value = 0
                getUserId()
            }
        }
    }

    private fun getUserId() {
        userId = mainRepository.getUserId()
    }

    override fun getPosts() {
        getFindListUseCase.execute(
            GetPostParameter(page.value ?: 0, location),
            object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        val addItem: ArrayList<MultipleRecyclerViewItem> =
                            if (findList.value != null) findList.value as ArrayList<MultipleRecyclerViewItem> else ArrayList()
                        findList.value = addItem.apply {
                            addAll(
                                t.value.map {
                                    PostItemViewModel(
                                        it,
                                        this@FindViewModel
                                    ).toRecyclerItem(it.user.id == userId)
                                }
                            )
                        }

                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    fun startPostFind() {
        startPostFind.call()
    }

    override fun showMap(post: Post) {
        _showMapInfo.value = post.location
    }

    override fun startChatting(post: Post) {
        _startChatInfo.value = post
    }
}