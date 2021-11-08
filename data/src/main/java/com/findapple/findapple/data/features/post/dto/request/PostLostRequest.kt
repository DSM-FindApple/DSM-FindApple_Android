package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import java.io.File

data class PostLostRequest(
    val title: String,
    val detailScript: String,
    val category: String,
    val lostAt: String,
    val images: List<File>,
    val latitude: Double,
    val longitude: Double
)

fun PostDataParameter.toLostRequest() =
    PostLostRequest(
        title = title,
        detailScript = detail,
        category = category,
        lostAt = actionTime,
        images = images,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude
    )