package com.findapple.findapple.presentation.features.post.viewModel

import android.net.Uri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.post.usecase.PostFindUseCase
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.base.SingleLiveEvent

class PostViewModel(private val postFindUseCase: PostFindUseCase) : BaseViewModel() {

    val clickedCategoryIndex = MutableLiveData<Int>()
    var preClickedCategoryIndex = MutableLiveData<Int>()
    val clickedCategoryTitle = MutableLiveData<String>()

    val photoList = MutableLiveData(ArrayList<Uri>())

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

}