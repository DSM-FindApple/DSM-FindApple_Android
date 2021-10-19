package com.findapple.data.features.post.dto.response

import com.findapple.domain.entity.Location
import com.findapple.domain.features.post.entity.Post
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

fun List<FindListResponse>.toEntity(): List<Post> =
    this.map { it.toEntity() }

fun FindListResponse.toEntity(): Post {
    return Post(
        id = findId,
        title = title,
        userName = userName,
        detailInfo = detailInfo,
        actionTime = findAt,
        writeTime = writeAt,
        category = category,
        location = Location(longitude, latitude),
        images = images.toStringList()
    )
}
