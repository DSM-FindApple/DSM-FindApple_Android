package com.findapple.findapple.app.features.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.features.mypage.service.UserService
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.disposables.CompositeDisposable

class MyPageViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val getUserDetailUseCase: GetUserDetailUseCase,
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val postService: PostService,
    private val compositeDisposable: CompositeDisposable
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(GetUserUseCase::class.java, GetUserDetailUseCase::class.java, UserService::class.java, UserRepository::class.java, PostService::class.java, CompositeDisposable::class.java)
            .newInstance(getUserUseCase, getUserDetailUseCase, userService, userRepository, postService, compositeDisposable)
}