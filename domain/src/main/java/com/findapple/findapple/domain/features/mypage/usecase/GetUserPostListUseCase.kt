package com.findapple.findapple.domain.features.mypage.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.mypage.service.UserService
import com.findapple.findapple.domain.features.post.entity.Post
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserPostListUseCase(
    private val service: UserService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, Result<List<Post>>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<List<Post>>> =
        service.getUserPostList()
}