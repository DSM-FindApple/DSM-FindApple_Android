package com.findapple.findapple.app.features.mypage.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findapple.findapple.R
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.app.base.BaseViewModel
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase
import com.findapple.findapple.BR
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.app.base.SingleLiveEvent
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.app.features.post.viewModel.PostItemViewModel
import com.findapple.findapple.domain.features.mypage.service.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getUserDetailUseCase: GetUserDetailUseCase,
    private val userService: UserService,
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel() {

    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> get() = _userProfile

    private val _userDetail = MutableLiveData<UserDetail>()
    val userDetail: LiveData<UserDetail> get() = _userDetail

    private val _myPageItems = MutableLiveData<List<RecyclerViewItem>>()
    val myPageItems: LiveData<List<RecyclerViewItem>> get() = _myPageItems

    private val _userPost = MutableLiveData<List<Post>>()
    val userPost: LiveData<List<Post>> get() = _userPost

    private val _showFindAppleLevelDetail = SingleLiveEvent<Unit>()
    val showFindAppleLevelDetail: LiveData<Unit> get() = _showFindAppleLevelDetail

    private val _startLogout = SingleLiveEvent<Unit>()
    val startLogout: LiveData<Unit> get() = _startLogout

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
                    getUserDetail()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    updateMyPageHeader()
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

    private fun getUserDetail() {
        getUserDetailUseCase.execute(
            data = Unit,
            singleObserver = object : DisposableSingleObserver<Result<UserDetail>>() {
                override fun onSuccess(t: Result<UserDetail>) {
                    if (t is Result.Success){
                        _userDetail.value = t.value
                        val postList = t.value.postedList
                        for (post in postList) {
                            _myPageItems.value = (_myPageItems.value as ArrayList<RecyclerViewItem>).apply {
                                add(
                                    RecyclerViewItem(
                                        R.layout.item_post,
                                        data = PostItemViewModel(post).apply { isMyPost = true },
                                        variableId = BR.vm
                                    )
                                )
                            }
                        }

                    }
                    updateMyPageHeader()
                }

                override fun onError(e: Throwable) {
                    updateMyPageHeader()
                }

            },
            AndroidSchedulers.mainThread()
        )
    }

    fun logoutClicked() {
        _startLogout.call()
    }

    fun logout() {
        val logoutObserver = userService.logout()
            .subscribe { _ ->
                _message.value = "로그아웃되었습니다"
                resetUserData()
            }
        compositeDisposable.add(logoutObserver)
    }

    private fun resetUserData() {
        _userProfile.value = null
        _userDetail.value = null
        _userPost.value = null
        _myPageItems.value = null
        getUserInfo()
    }



    fun showFindAppleLevelDetail() {
        _showFindAppleLevelDetail.call()
    }

}