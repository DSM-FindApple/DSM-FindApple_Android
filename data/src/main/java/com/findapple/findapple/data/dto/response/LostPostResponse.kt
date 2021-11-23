package com.findapple.findapple.data.dto.response

data class LostPostResponse(
    val category: String,
    val detail: String,
    val kakaoId: Long,
    val latitude: Double,
    val longitude: Double,
    val lostAt: String,
    val lostId: Int,
    val lostImages: List<String>,
    val lostUser: String,
    val profileUrl: String,
    val title: String,
    val topComment: CommentResponse,
    val writeAt: String
    )