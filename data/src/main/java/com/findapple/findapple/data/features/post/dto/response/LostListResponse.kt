package com.findapple.findapple.data.features.post.dto.response

import com.findapple.findapple.domain.features.post.entity.PostListData
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

fun LostListResponse.toEntity() =
    PostListData(
        id = lostId,
        title = title,
        userName = userName,
        detailInfo = detailInfo,
        actionTime = lostAt,
        writeTime = writeAt,
        category = category,
        latitude = latitude,
        longitude = longitude,
        images = images.toStringList()
    )