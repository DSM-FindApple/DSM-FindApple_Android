package com.findapple.findapple.data.features.post.dto.request

data class UpdateLostPostRequest(
    val category: String,
    val detail: String,
    val latitude: Double,
    val longitude: Double,
    val lostAt: String,
    val title: String
)