package com.findapple.findapple.domain.features.comment.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.comment.repository.CommentRepository
import com.findapple.findapple.domain.features.post.entity.Comment
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class CommentServiceImpl(private val commentRepository: CommentRepository, private val errorHandler: ErrorHandler): CommentService {
    override fun getComments(id: Long): Single<Result<List<Comment>>> =
        commentRepository.getComments(id).toResult(errorHandler)
}