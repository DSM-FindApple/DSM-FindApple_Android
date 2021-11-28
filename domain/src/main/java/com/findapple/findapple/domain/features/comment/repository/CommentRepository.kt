package com.findapple.findapple.domain.features.comment.repository

import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single

interface CommentRepository {
    fun getComments(id: Long, isLost: Boolean): Single<List<Comment>>

    fun postComments(id: Long, comment: String, isLost: Boolean): Single<Unit>
}