package com.findapple.findapple.domain.features.comment.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.post.entity.Comment
import io.reactivex.Single

interface CommentService {
    fun getComments(id: Long): Single<Result<List<Comment>>>
}