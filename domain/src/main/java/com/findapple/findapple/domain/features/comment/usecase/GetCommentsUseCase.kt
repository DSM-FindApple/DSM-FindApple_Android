package com.findapple.findapple.domain.features.comment.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.comment.parameter.GetCommentsParameter
import com.findapple.findapple.domain.features.comment.service.CommentService
import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetCommentsUseCase(private val service: CommentService, compositeDisposable: CompositeDisposable): UseCase<GetCommentsParameter, Result<List<Comment>>>(compositeDisposable) {
    override fun create(data: GetCommentsParameter): Single<Result<List<Comment>>> =
        service.getComments(data)
}