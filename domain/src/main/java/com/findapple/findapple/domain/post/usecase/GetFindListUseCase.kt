package com.findapple.findapple.domain.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.post.entity.PostListData
import com.findapple.findapple.domain.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetFindListUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Unit, Result<PostListData>>(compositeDisposable) {
    override fun create(data: Unit): Single<Result<PostListData>> =
        postService.getPostList(false)
}