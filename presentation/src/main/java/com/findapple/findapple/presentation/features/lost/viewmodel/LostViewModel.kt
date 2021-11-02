package com.findapple.findapple.presentation.features.lost.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.R
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.BR
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.base.SingleLiveEvent
import com.findapple.findapple.presentation.bindingadapter.RecyclerViewItem
import com.findapple.findapple.presentation.features.post.viewModel.PostItemViewModel
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
                    if (t is Result.Success) {
                        lostList.value =
                            t.value.map { PostItemViewModel(it, false).toRecyclerItem() }
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
            itemLayoutId = R.layout.item_lost_post
        )

    fun startPost() {
        _startPostLost.call()
    }


}