package com.findapple.findapple.domain.features.comment.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.comment.parameter.GetCommentsParameter
import com.findapple.findapple.domain.features.comment.parameter.PostCommentParameter
import com.findapple.findapple.domain.features.comment.repository.CommentRepository
import com.findapple.findapple.domain.features.post.entity.Comment
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class CommentServiceImpl(private val commentRepository: CommentRepository, private val errorHandler: ErrorHandler): CommentService {
    override fun getComments(parameter: GetCommentsParameter): Single<Result<List<Comment>>> =
        commentRepository.getComments(parameter.id, parameter.isLost).toResult(errorHandler)

    override fun postComments(parameter: PostCommentParameter): Single<Result<Unit>> =
        commentRepository.postComments(parameter.id, parameter.comment, parameter.isLost).toResult(errorHandler)
}