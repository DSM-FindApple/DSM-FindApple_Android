package com.findapple.findapple.data.features.comment.datasource

import com.findapple.findapple.data.dto.response.CommentResponse
import com.findapple.findapple.data.features.comment.dto.request.PostCommentRequest
import com.findapple.findapple.data.features.comment.remote.CommentApi
import io.reactivex.Single

class CommentDatasourceImpl(private val commentApi: CommentApi) : CommentDatasource {
    override fun getComments(id: Long, isLost: Boolean): Single<List<CommentResponse>> {
        val commentType = if (isLost) "LOST" else "FIND"
        return commentApi.getComments(commentType, id)
    }

    override fun postComment(id: Long, comment: String, isLost: Boolean): Single<Unit> {
        val commentType = if (isLost) "LOST" else "FIND"
        return commentApi.postComments(commentType, id, PostCommentRequest(comment))
    }

}