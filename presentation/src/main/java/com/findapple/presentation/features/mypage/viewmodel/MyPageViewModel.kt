package com.findapple.presentation.features.mypage.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.presentation.base.BaseViewModel
import com.findapple.domain.entity.User
import com.findapple.domain.features.post.entity.Post
import com.findapple.domain.features.mypage.usecase.GetUserPostListUseCase
import com.findapple.presentation.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getUserPostListUseCase: GetUserPostListUseCase
) : BaseViewModel() {

    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

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
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }


            },
            AndroidSchedulers.mainThread()
        )
    }

    fun showFindAppleLevelDetail(){
        _showFindAppleLevelDetail.call()
    }

}