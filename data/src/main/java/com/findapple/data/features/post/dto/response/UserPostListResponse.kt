package com.findapple.data.features.post.dto.response

import java.util.*

data class UserPostListResponse(val id: Int,
                                val title: String,
                                val userName: String,
                                val detailInfo: String,
                                val actionTime: Date,
                                val writeTime: Date,
                                val category: String,
                                val latitude: Double,
                                val longitude: Double,
                                val images: List<String>)