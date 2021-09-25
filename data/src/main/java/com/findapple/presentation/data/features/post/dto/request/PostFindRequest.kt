package com.findapple.presentation.data.features.post.dto.request

import com.findapple.presentation.domain.features.post.`object`.PostDataObject
import java.io.File
import java.util.*

data class PostFindRequest(
    val title: String,
    val detailScript: String,
    val category: String,
    val findAt: Date,
    val images: List<File>,
    val latitude: Double,
    val longitude: Double
)

fun PostDataObject.toFindRequest() =
    PostFindRequest(
        title = title,
        detailScript = detail,
        category = category,
        findAt = actionTime,
        images = images,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude
    )

