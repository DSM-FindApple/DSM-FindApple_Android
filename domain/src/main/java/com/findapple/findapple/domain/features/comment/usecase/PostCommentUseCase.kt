package com.findapple.findapple.domain.features.comment.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.comment.parameter.PostCommentParameter
import com.findapple.findapple.domain.features.comment.service.CommentService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostCommentUseCase(
    private val commentService: CommentService,
    compositeDisposable: CompositeDisposable
) : UseCase<PostCommentParameter, Result<Unit>>(compositeDisposable) {
    override fun create(data: PostCommentParameter): Single<Result<Unit>> =
        commentService.postComments(data)

}