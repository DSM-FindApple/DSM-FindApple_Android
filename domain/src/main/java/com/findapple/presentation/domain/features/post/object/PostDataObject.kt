package com.findapple.presentation.domain.features.post.`object`

import com.findapple.presentation.domain.`object`.LocationInfo
import java.io.File
import java.util.*

data class PostDataObject(
    val title: String,
    val detail: String,
    val category: String,
    val actionTime: Date,
    val images: List<File>,
    val locationInfo: LocationInfo
)