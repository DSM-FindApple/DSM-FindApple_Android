package com.findapple.findapple.data.dto.response

import java.util.*

data class FindListResponse(
    val findId: Int,
    val title: String,
    val userName: String,
    val detailInfo: String,
    val findAt: Date,
    val writeAt: Date,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val images: List<ImageResponse>
)