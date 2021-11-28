package com.findapple.findapple.data.features.comment.repository

import com.findapple.findapple.data.dto.response.toEntity
import com.findapple.findapple.data.features.comment.datasource.CommentDatasource
import com.findapple.findapple.domain.features.comment.repository.CommentRepository
import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single

class CommentRepositoryImpl(private val commentDatasource: CommentDatasource): CommentRepository {
    override fun getComments(id: Long, isLost: Boolean): Single<List<Comment>> =
        commentDatasource.getComments(id, isLost).map { it.toEntity() }

    override fun postComments(id: Long, comment: String, isLost: Boolean): Single<Unit> =
        commentDatasource.postComment(id, comment, isLost)
}