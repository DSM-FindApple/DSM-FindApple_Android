package com.findapple.findapple.app.features.mypage.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.R
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase
import com.findapple.findapple.BR
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.MultipleRecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.features.mypage.service.UserService
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getUserDetailUseCase: GetUserDetailUseCase,
    private val userService: UserService,
    private val userRepository: UserRepository,
    override val postService: PostService,
    private val compositeDisposable: CompositeDisposable
) : BasePostViewModel() {

    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

    private val _userDetail = MutableLiveData<UserDetail>()
    val userDetail: LiveData<UserDetail> get() = _userDetail

    private val _myPageItems = MutableLiveData<ArrayList<MultipleRecyclerViewItem>>()
    val myPageItems: LiveData<ArrayList<MultipleRecyclerViewItem>> get() = _myPageItems

    private val _showFindAppleLevelDetail = SingleLiveEvent<Unit>()
    val showFindAppleLevelDetail: LiveData<Unit> get() = _showFindAppleLevelDetail

    private val _message = SingleLiveEvent<String>()
    val message: LiveData<String> get() = _message

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
                    getPosts()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    initMyPageHeader()
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    private fun initMyPageHeader() {
        _myPageItems.value = ArrayList<MultipleRecyclerViewItem>().apply {
            add(
                MultipleRecyclerViewItem(
                    R.layout.item_mypage_header,
                    this@MyPageViewModel,
                    BR.vm,
                    "dd",
                    BR.image
                )
            )
        }
    }

    override fun getPosts() {
        getUserDetailUseCase.execute(
            data = Unit,
            singleObserver = object : DisposableSingleObserver<Result<UserDetail>>() {
                override fun onSuccess(t: Result<UserDetail>) {
                    initMyPageHeader()
                    if (t is Result.Success){
                        _userDetail.value = t.value
                        val postList = t.value.postedList
                        if (postList != null) {
                            for (post in postList) {
                                _myPageItems.value = myPageItems.value?.apply {
                                    add(
                                        MultipleRecyclerViewItem(
                                            R.layout.item_post,
                                            data1 = PostItemViewModel(post, this@MyPageViewModel).apply { isMyPost = true },
                                            variableId1 = BR.vm,
                                            data2 = this@MyPageViewModel,
                                            variableId2 = BR.postVm
                                        )
                                    )
                                }
                            }
                        }

                    }
                }

                override fun onError(e: Throwable) {
                    initMyPageHeader()
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    fun logout() {
        val logoutObserver = userService.logout()
            .subscribe { _ ->
                userRepository.resetToken()
                _message.value = "???????????????????????????"
                resetUserData()
            }
        compositeDisposable.add(logoutObserver)
    }

    private fun resetUserData() {
        _userProfile.value = null
        _userDetail.value = null
        _myPageItems.value = null
        getUserInfo()
    }



    fun showFindAppleLevelDetail() {
        _showFindAppleLevelDetail.call()
    }

}