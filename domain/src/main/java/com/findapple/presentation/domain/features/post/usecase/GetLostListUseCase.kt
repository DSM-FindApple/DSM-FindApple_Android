package com.findapple.presentation.domain.features.post.usecase

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.base.UseCase
import com.findapple.presentation.domain.features.post.entity.PostListData
import com.findapple.presentation.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetLostListUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, Result<PostListData>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<PostListData>> =
        postService.getPostList(true)
}