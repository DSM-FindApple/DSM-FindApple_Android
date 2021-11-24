package com.findapple.findapple.app.features.find.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.app.features.post.viewModel.toRecyclerItem
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class FindViewModel(
    private val getFindListUseCase: GetFindListUseCase,
    private val mainRepository: MainRepository
) : BaseViewModel() {

    val findList = MutableLiveData<List<RecyclerViewItem>>()

    val townName = MutableLiveData<String>()
    val cityName = MutableLiveData<String>()

    val startPostFind = SingleLiveEvent<Unit>()

    var userId: Long = -1

    val page = MutableLiveData<Int>()

    var location = Location(127.3635946, 36.3914388)
    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                findList.value = null
                page.value = 0
                getUserId()
                getFindList()
            }
        }
    }

    private fun getUserId() {
        userId = mainRepository.getUserId()
    }

    private fun getFindList() {
        getFindListUseCase.execute(
            GetPostParameter(page.value ?: 0, location),
            object : DisposableSingleObserver<Result<List<Post>>>() {
                override fun onSuccess(t: Result<List<Post>>) {
                    if (t is Result.Success) {
                        findList.value =
                            t.value.map { PostItemViewModel(it).toRecyclerItem(it.user.id == userId) }
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