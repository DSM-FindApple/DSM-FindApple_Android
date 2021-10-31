package com.findapple.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.mypage.usecase.GetUserPostListUseCase
import com.findapple.findapple.presentation.BR
import com.findapple.findapple.presentation.R
import com.findapple.findapple.presentation.base.SingleLiveEvent
import com.findapple.findapple.presentation.bindingadapter.RecyclerViewItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getUserPostListUseCase: GetUserPostListUseCase
) : BaseViewModel() {

    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

    private val _myPageItems = MutableLiveData<List<RecyclerViewItem>>()
    val myPageItems: LiveData<List<RecyclerViewItem>> get() = _myPageItems

    private val _userPost = MutableLiveData<List<Post>>()
    val userPost: LiveData<List<Post>> get() = _userPost

    private val _showFindAppleLevelDetail = SingleLiveEvent<Unit>()
    val showFindAppleLevelDetail: LiveData<Unit> get() = _showFindAppleLevelDetail

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                getUserInfo()
            }
        }
    }

    private fun getUserInfo() {
        getUserUseCase.execute(
            data = Unit,
            singleObserver = object : DisposableSingleObserver<User>() {

                override fun onSuccess(t: User) {
                    _userProfile.value = t
                    updateMyPageHeader()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }


            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun updateMyPageHeader() {
        _myPageItems.value = ArrayList<RecyclerViewItem>().apply {
            add(
                RecyclerViewItem(
                    R.layout.item_mypage_header,
                    this@MyPageViewModel,
                    BR.vm
                )
            )
        }
    }

    fun showFindAppleLevelDetail() {
        _showFindAppleLevelDetail.call()
    }

}