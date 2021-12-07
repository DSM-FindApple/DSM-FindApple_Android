package com.findapple.findapple.domain.features.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.post.parameter.UpdateDataParameter
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class UpdatePostUseCase(private val postService: PostService,compositeDisposable: CompositeDisposable): UseCase<UpdateDataParameter, Result<Unit>>(compositeDisposable) {
    override fun create(data: UpdateDataParameter): Single<Result<Unit>> =
        postService.updatePost(data)
}