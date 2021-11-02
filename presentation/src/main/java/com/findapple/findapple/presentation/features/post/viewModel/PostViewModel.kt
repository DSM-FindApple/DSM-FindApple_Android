package com.findapple.findapple.presentation.features.post.viewModel

import android.net.Uri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.domain.features.post.usecase.PostLostUseCase
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.base.SingleLiveEvent

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
        if (isLost) {
            postLost()
        } else {
            postFind()
        }
    }

    private fun postLost() {
        val category =
            when(clickedCategoryIndex.value) {
                0 -> "EAR_PHONE"
                1 -> "CELL_PHONE"
                2 -> "MACHINE"
                3 -> "CLOTHES"
                4 -> "ACC"
                5 -> "WALLET"
                6 -> "CAR"
                else -> ""
            }
        postLostUseCase.execute(
            TODO("게시물 올리기")
        )
    }

    private fun postFind() {
    }
}