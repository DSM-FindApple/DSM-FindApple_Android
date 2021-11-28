package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Comment

data class CommentResponse(
    val comment: String,
    val commentId: Long,
    val nickName: String,
    val postId: Long,
    val profileUrl: String,
    val reComment: List<ReCommentResponse>,
    val userId: Long,
    val writeAt: String
)

fun List<CommentResponse>.toEntity() =
    this.map { it.toEntity() }

fun CommentResponse.toEntity() =
    Comment(
        comment = comment,
        id = commentId,
        user = User(userId, nickName, profileUrl)
    )