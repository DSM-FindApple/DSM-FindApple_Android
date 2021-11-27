package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Comment

data class TopCommentResponse(
    val comment: String,
    val commentId: Long,
    val nickName: String,
    val postId: Long,
    val userId: Long,
    val writeAt: String,
    val profileUrl: String
)

fun TopCommentResponse.toEntity() =
    Comment(
        id = commentId,
        user = User(
            userId,
            nickName,
            profileUrl
        ),
        comment = comment
    )