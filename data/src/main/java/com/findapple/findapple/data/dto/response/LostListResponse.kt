package com.findapple.findapple.data.dto.response

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