package com.findapple.findapple.domain.features.comment.repository

import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single

interface CommentRepository {
    fun getComments(id: Long): Single<List<Comment>>
}