package com.findapple.presentation.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.base.Result
import com.findapple.domain.features.post.entity.Post
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.BR
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.base.SingleLiveEvent
import com.findapple.presentation.bindingadapter.RecyclerViewItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class LostViewModel(private val getLostListUseCase: GetLostListUseCase) : BaseViewModel() {

    val lostList = MutableLiveData<List<RecyclerViewItem>>()

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    private val _startPostLost = SingleLiveEvent<Unit>()
    val startPostLost: LiveData<Unit> get() = _startPostLost

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                getLostList()
            }
        }
    }

    private fun getLostList() {
        getLostListUseCase.execute(
            Unit, object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {

                }

                override fun onError(e: Throwable) {

                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun LostItemViewModel.toRecyclerItem(): RecyclerViewItem =
        RecyclerViewItem(
            data = this,
            variableId = BR.vm,
            itemLayoutId = R.layout.item_lost_post
        )

    fun startPost() {
        _startPostLost.call()
    }

    inner class LostItemViewModel(val post: Post) {
        fun clickComment() {

        }
    }
}