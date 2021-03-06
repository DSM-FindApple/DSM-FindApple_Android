package com.findapple.findapple.domain.features.post.parameter

import com.findapple.findapple.domain.entity.Location
import java.io.File

data class PostDataParameter(
    val title: String,
    val detail: String,
    val category: String,
    val actionTime: String,
    val images: List<File>,
    val locationInfo: Location
)