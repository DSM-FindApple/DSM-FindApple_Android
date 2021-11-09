package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

data class PostLostRequest(
    val title: String,
    val detailScript: String,
    val category: String,
    val lostAt: String,
    val images: List<MultipartBody.Part>,
    val latitude: Double,
    val longitude: Double
)

fun PostDataParameter.toLostRequest() =
    PostLostRequest(
        title = title,
        detailScript = detail,
        category = category,
        lostAt = actionTime,
        images = images.map {
            val requestBody = RequestBody.create(("image/*".toMediaTypeOrNull()), it)
            MultipartBody.Part.createFormData("images", it.path, requestBody)
        },
        latitude = locationInfo.latitude,
        longitude = locationInfo.longitude
    )

