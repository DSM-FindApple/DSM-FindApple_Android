package com.findapple.domain.features.post.entity

import com.findapple.domain.entity.Location
import java.util.*

data class Post(
    val id: Int,
    val title: String,
    val userName: String,
    val detailInfo: String,
    val actionTime: Date,
    val writeTime: Date,
    val category: String,
    val location: Location,
    val images: List<String>
)