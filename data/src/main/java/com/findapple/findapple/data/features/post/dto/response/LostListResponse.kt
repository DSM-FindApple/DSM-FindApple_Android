package com.findapple.findapple.data.features.post.dto.response

import com.findapple.findapple.data.dto.response.TopCommentResponse
import com.findapple.findapple.data.dto.response.toEntity
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post

data class LostListResponse(
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
    val topComment: TopCommentResponse,
    val writeAt: String
)

fun List<LostListResponse>.toEntity(): List<Post> =
    this.map { it.toEntity() }

fun LostListResponse.toEntity() =
    Post(
        id = lostId,
        title = title,
        isLost = true,
        user = User(name = lostUser, id = kakaoId, profileImage = profileUrl),
        detailInfo = detail,
        actionTime = lostAt,
        writeTime = writeAt,
        category = category,
        location = Location(longitude, latitude),
        images = lostImages,
        topComment = topComment.toEntity()
    )