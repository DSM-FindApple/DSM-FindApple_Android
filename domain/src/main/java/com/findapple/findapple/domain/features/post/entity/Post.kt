package com.findapple.findapple.domain.features.post.entity

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.entity.User

data class Post(
    val id: Long,
    val title: String,
    val user: User,
    val detailInfo: String,
    val actionTime: String,
    val writeTime: String,
    val category: String,
    val location: Location,
    val images: List<String>,
    val topComment: Comment
)