package com.findapple.findapple.data.features.comment.datasource

import com.findapple.findapple.data.dto.response.CommentResponse
import io.reactivex.Single

interface CommentDatasource {
    fun getComments(id: Long, isLost: Boolean): Single<List<CommentResponse>>

    fun postComment(id: Long, comment: String, isLost: Boolean): Single<Unit>
}