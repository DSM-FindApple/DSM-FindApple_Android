package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post

data class LostPostResponse(
    val category: String,
    val detail: String,
    val kakaoId: Long,
    val latitude: Double,
    val longitude: Double,
    val lostAt: String,
    val lostId: Long,
    val lostImages: List<String>,
    val lostUser: String,
    val profileUrl: String,
    val title: String,
    val topComment: CommentResponse,
    val writeAt: String
)

fun List<LostPostResponse>.toEntity() =
    this.map { it.toEntity() }

fun LostPostResponse.toEntity() =
    Post(
        category = category,
        detailInfo = detail,
        user = User(kakaoId, lostUser, profileUrl),
        location = Location(longitude, latitude),
        actionTime = lostAt,
        writeTime = writeAt,
        images = lostImages,
        id = lostId,
        title = title
    )