package com.findapple.findapple.app.features.find.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.MultipleRecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.app.features.post.viewModel.toRecyclerItem
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class FindViewModel(
    private val getFindListUseCase: GetFindListUseCase,
    private val mainRepository: MainRepository
) : BasePostViewModel() {

    val findList = MutableLiveData<List<MultipleRecyclerViewItem>>()

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

    fun loadFindList() {
        getFindListUseCase.execute(
            GetPostParameter(page.value ?: 0, location),
            object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        findList.value =
                            t.value.map { PostItemViewModel(it, this@FindViewModel).toRecyclerItem(it.user.id == userId) }
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
}