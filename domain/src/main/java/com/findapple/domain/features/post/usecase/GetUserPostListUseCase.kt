package com.findapple.domain.features.post.usecase

import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import com.findapple.domain.features.post.entity.Post
import com.findapple.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserPostListUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, Result<Post>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<Post>> =
        postService.getUserPostList()
}