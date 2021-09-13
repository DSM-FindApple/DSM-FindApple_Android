package com.findapple.findapple.domain.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.post.`object`.PostDataObject
import com.findapple.findapple.domain.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostFindUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) : UseCase<PostDataObject, Result<Unit>>(compositeDisposable) {
    override fun create(data: PostDataObject): Single<Result<Unit>> =
        postService.postFeed(false)
}