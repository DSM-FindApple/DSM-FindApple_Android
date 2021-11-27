package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Comment

data class TopCommentResponse(
    val comment: String,
    val commentId: Long,
    val nickName: String,
    val postId: Long,
    val userId: Long,
    val writeAt: String
)

fun TopCommentResponse.toEntity() =
    Comment(
        id = commentId,
        user = User(
            userId,
            nickName,
            "todo:이미지 넣기"
        ),
        comment = comment
    )