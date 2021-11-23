package com.findapple.findapple.data.dto.response

data class CommentResponse(
    val comment: String,
    val commentId: Int,
    val nickName: String,
    val postId: Int,
    val profileUrl: String,
    val reComment: List<ReCommentResponse>,
    val userId: Int,
    val writeAt: String
    )