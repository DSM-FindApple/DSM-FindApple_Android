package com.findapple.data.features.post.dto.response

import com.findapple.domain.entity.Location
import com.findapple.domain.features.post.entity.Post
import java.util.*

data class LostListResponse(
    val lostId: Int,
    val title: String,
    val userName: String,
    val detailInfo: String,
    val lostAt: Date,
    val writeAt: Date,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val images: List<ImageResponse>
)

fun List<LostListResponse>.toEntity(): List<Post> =
    this.map { it.toEntity() }


fun LostListResponse.toEntity() =
    Post(
        id = lostId,
        title = title,
        userName = userName,
        detailInfo = detailInfo,
        actionTime = lostAt,
        writeTime = writeAt,
        category = category,
        location = Location(longitude, latitude),
        images = images.toStringList()
    )