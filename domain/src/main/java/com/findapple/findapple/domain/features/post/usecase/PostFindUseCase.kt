package com.findapple.findapple.domain.features.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostFindUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) : UseCase<PostDataParameter, Result<Unit>>(compositeDisposable) {
    override fun create(data: PostDataParameter): Single<Result<Unit>> =
        postService.postFeed(data, false)
}