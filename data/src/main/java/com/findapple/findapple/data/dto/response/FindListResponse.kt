package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.post.entity.PostListData
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

fun FindListResponse.toEntity(): PostListData {
    val entityImages = ArrayList<String>()
    for (i in this.images) {
        entityImages.add(i.image)
    }
    return PostListData(
        id = findId,
        title = title,
        userName = userName,
        detailInfo = detailInfo,
        actionTime = findAt,
        writeTime = writeAt,
        category = category,
        latitude = latitude,
        longitude = longitude,
        images = entityImages
    )
}
