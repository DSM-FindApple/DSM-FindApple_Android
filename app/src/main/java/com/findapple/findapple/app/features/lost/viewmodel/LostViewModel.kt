package com.findapple.findapple.app.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.R
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.BR
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class LostViewModel(private val getLostListUseCase: GetLostListUseCase) : BaseViewModel() {

    val lostList = MutableLiveData<List<RecyclerViewItem>>()

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    private val _startPostLost = SingleLiveEvent<Unit>()
    val startPostLost: LiveData<Unit> get() = _startPostLost

    val page = MutableLiveData<Int>()

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                lostList.value = null
                page.value = 1
                getLostList()
            }
        }
    }

    private fun getLostList() {
        getLostListUseCase.execute(
            page.value ?: 0, object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        lostList.value =
                            t.value.map { PostItemViewModel(it).toRecyclerItem() }
                    }
                }

                override fun onError(e: Throwable) {
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun PostItemViewModel.toRecyclerItem(): RecyclerViewItem =
        RecyclerViewItem(
            data = this,
            variableId = BR.vm,
            itemLayoutId = R.layout.item_post
        )

    fun startPost() {
        _startPostLost.call()
    }

    inner class PostItemViewModel(val post: Post) {
        var isMyPost = false
    }

}