package com.findapple.domain.features.mypage.usecase

import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import com.findapple.domain.features.mypage.service.UserService
import com.findapple.domain.features.post.entity.Post
import com.findapple.domain.features.post.service.PostService
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