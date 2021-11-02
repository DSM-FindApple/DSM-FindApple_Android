package com.findapple.findapple.domain.features.post.parameter

import com.findapple.findapple.domain.entity.Location
import java.io.File
import java.util.*

data class PostDataParameter(
    val title: String,
    val detail: String,
    val category: String,
    val actionTime: Date,
    val images: List<File>,
    val locationInfo: Location
)