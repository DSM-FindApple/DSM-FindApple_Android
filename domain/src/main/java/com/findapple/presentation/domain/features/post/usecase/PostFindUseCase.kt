package com.findapple.presentation.domain.features.post.usecase

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.base.UseCase
import com.findapple.presentation.domain.features.post.`object`.PostDataObject
import com.findapple.presentation.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostFindUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) : UseCase<PostDataObject, Result<Unit>>(compositeDisposable) {
    override fun create(data: PostDataObject): Single<Result<Unit>> =
        postService.postFeed(data, false)
}