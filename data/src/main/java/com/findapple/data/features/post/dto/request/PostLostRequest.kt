package com.findapple.data.features.post.dto.request

import com.findapple.domain.features.post.`object`.PostDataObject
import java.io.File
import java.util.*

data class PostLostRequest(
    val title: String,
    val detailScript: String,
    val category: String,
    val lostAt: Date,
    val images: List<File>,
    val latitude: Double,
    val longitude: Double
)

fun PostDataObject.toLostRequest() =
    PostLostRequest(
        title = title,
        detailScript = detail,
        category = category,
        lostAt = actionTime,
        images = images,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude
    )