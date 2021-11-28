package com.findapple.findapple.app.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.app.features.post.viewModel.toRecyclerItem
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class LostViewModel(
    private val getLostListUseCase: GetLostListUseCase,
    private val mainRepository: MainRepository
) : BasePostViewModel() {

    val lostList = MutableLiveData<List<RecyclerViewItem>>()

    private val _startPostLost = SingleLiveEvent<Unit>()
    val startPostLost: LiveData<Unit> get() = _startPostLost

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

    fun loadLostList() {
        getLostListUseCase.execute(
            GetPostParameter(page.value ?: 0, location),
            object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        val addItem: ArrayList<RecyclerViewItem> =
                            if (lostList.value != null) lostList.value as ArrayList<RecyclerViewItem> else ArrayList()
                        lostList.value = addItem.apply {
                            addAll(t.value.map { PostItemViewModel(it).toRecyclerItem(it.user.id == userId) })
                        }

                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    fun commentClicked(id: Long) {

    }

    fun startPost() {
        _startPostLost.call()
    }
}