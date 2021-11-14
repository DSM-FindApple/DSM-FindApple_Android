package com.findapple.findapple.domain.features.post.parameter

import android.net.Uri
import com.findapple.findapple.domain.entity.Location

data class PostDataParameter(
    val title: String,
    val detail: String,
    val category: String,
    val actionTime: String,
    val images: List<Uri>,
    val locationInfo: Location
)