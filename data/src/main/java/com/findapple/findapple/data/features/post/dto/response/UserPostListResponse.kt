package com.findapple.findapple.data.features.post.dto.response

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.entity.Post
import java.util.*

data class UserPostListResponse(
    val id: Int,
    val title: String,
    val userName: String,
    val detailInfo: String,
    val actionTime: Date,
    val writeTime: Date,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val images: List<String>
)

fun List<UserPostListResponse>.toEntity() =
    this.map { it.toEntity() }

fun UserPostListResponse.toEntity() =
    Post(
        id,
        title,
        userName,
        detailInfo,
        actionTime,
        writeTime,
        category,
        location = Location(longitude, latitude),
        images
    )