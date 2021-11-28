package com.findapple.findapple.data.features.comment.repository

import com.findapple.findapple.data.features.comment.datasource.CommentDatasource
import com.findapple.findapple.domain.features.comment.repository.CommentRepository
import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single

class CommentRepositoryImpl(private val commentDatasource: CommentDatasource): CommentRepository {
    override fun getComments(id: Long): Single<List<Comment>> =
        commentDatasource.getComments().map {  }
}