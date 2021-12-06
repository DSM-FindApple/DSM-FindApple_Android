package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter

data class UpdateFindPostRequest(
    val category: String,
    val detail: String,
    val latitude: Double,
    val longitude: Double,
    val findAt: String,
    val title: String
)

fun PostDataParameter.toUpdateFindRequest() =
    UpdateFindPostRequest(
        category = category,
        detail = detail,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude,
        findAt = actionTime,
        title = title
    )