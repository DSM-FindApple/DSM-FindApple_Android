package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter

data class UpdateLostPostRequest(
    val category: String,
    val detail: String,
    val latitude: Double,
    val longitude: Double,
    val lostAt: String,
    val title: String
)

fun PostDataParameter.toUpdateLostRequest() =
    UpdateLostPostRequest(
        category = category,
        detail = detail,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude,
        lostAt = actionTime,
        title = title
    )