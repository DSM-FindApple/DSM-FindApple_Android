package com.findapple.findapple.data.dto.response

data class TopCommentResponse(
    val comment: String,
    val commentId: Int,
    val nickName: String,
    val postId: Int,
    val userId: Int,
    val writeAt: String
)