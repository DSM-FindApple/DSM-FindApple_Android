package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import java.io.File

data class PostFindRequest(
    val title: String,
    val detailScript: String,
    val category: String,
    val findAt: String,
    val images: List<File>,
    val latitude: Double,
    val longitude: Double
)

fun PostDataParameter.toFindRequest() =
    PostFindRequest(
        title = title,
        detailScript = detail,
        category = category,
        findAt = actionTime,
        images = images,
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude
    )

