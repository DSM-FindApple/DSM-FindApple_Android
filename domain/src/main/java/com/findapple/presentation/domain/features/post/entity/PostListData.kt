package com.findapple.presentation.domain.features.post.entity

import java.util.*

data class PostListData(
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