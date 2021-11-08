package com.findapple.findapple.presentation.features.post.viewModel

import android.net.Uri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.errorhandler.Error
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.domain.features.post.usecase.PostLostUseCase
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import java.io.File

class PostViewModel(
    private val postFindUseCase: PostFindUseCase,
    private val postLostUseCase: PostLostUseCase
) : BaseViewModel() {

    val clickedCategoryIndex = MutableLiveData<Int>()
    var preClickedCategoryIndex = MutableLiveData<Int>()
    val clickedCategoryTitle = MutableLiveData<String>()

    val photoList = MutableLiveData(ArrayList<Uri>())

    val title = MutableLiveData<String>()
    val detail = MutableLiveData<String>()

    private val _startCamera = SingleLiveEvent<Unit>()
    val startCamera: LiveData<Unit> get() = _startCamera

    private val _startGallery = SingleLiveEvent<Unit>()
    val startGallery: LiveData<Unit> get() = _startGallery

    private val _message = SingleLiveEvent<String>()
    val message: LiveData<String> get() = _message

    val location = MutableLiveData<Location>()

    val year = MutableLiveData<Int>()
    val month = MutableLiveData<Int>()
    val day = MutableLiveData<Int>()

    val hour = MutableLiveData<Int>()
    val minute = MutableLiveData<Int>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun categoryClicked(position: Int, title: String) {
        clickedCategoryIndex.value.run {
            if (this != position) {
                clickedCategoryTitle.value = title
                clickedCategoryIndex.value = position
            } else {
                clickedCategoryTitle.value = null
                clickedCategoryIndex.value = null
            }
        }

    }

    fun startCamera() {
        _startCamera.call()
    }

    fun startGallery() {
        _startGallery.call()
    }

    fun deletePhoto(position: Int) {
        photoList.value!!.removeAt(position)
        val list = photoList.value
        photoList.value = list
        _message.value = "삭제되었습니다"
    }

    fun post(isLost: Boolean) {
        val category =
            when (clickedCategoryIndex.value) {
                0 -> "EAR_PHONE"
                1 -> "CELL_PHONE"
                2 -> "MACHINE"
                3 -> "CLOTHES"
                4 -> "ACC"
                5 -> "WALLET"
                6 -> "CAR"
                else -> ""
            }

        val actionTime = "${year.value}-${String.format("%02d", month.value)}-${String.format("%02d", day.value)} ${String.format("%02d", hour.value)}:${String.format("%02d", minute.value)}"

        val postParam = PostDataParameter(
            title = title.value!!,
            detail = detail.value!!,
            category = category,
            actionTime = actionTime,
            images = photoList.value!!.map { File(it.path!!) },
            locationInfo = location.value?: Location(127.3635946, 36.3914388)
            )
        if (isLost) {
            postLost(postParam)
        } else {
            postFind(postParam)
        }
    }

    private val postObserver = object : DisposableSingleObserver<Result<Unit>>() {
        override fun onSuccess(t: Result<Unit>) {
            if(t is Result.Success) {
                _message.value = "게시되었습니다"
            }
            else if(t is Result.Failure) {
                doOnError(t)
            }
        }

        override fun onError(e: Throwable) {
        }

    }

    private fun postLost(postParam: PostDataParameter) {
        postLostUseCase.execute(
            postParam,
            postObserver,
            AndroidSchedulers.mainThread()
        )
    }

    private fun postFind(postParam: PostDataParameter) {
        postFindUseCase.execute(
            postParam,
            postObserver,
            AndroidSchedulers.mainThread()
        )
    }



    private fun doOnError(reason: Result.Failure<Unit>) {
        when(reason.reason) {
            Error.InternalServer -> {
                _message.value = "서버사용량이 많습니다"
            }
        }
    }


}