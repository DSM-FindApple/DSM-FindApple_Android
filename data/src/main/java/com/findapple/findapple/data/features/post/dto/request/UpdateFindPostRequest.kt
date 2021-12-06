package com.findapple.findapple.data.features.post.dto.request

data class UpdateFindPostRequest(
    val category: String,
    val detail: String,
    val latitude: Double,
    val longitude: Double,
    val findAt: String,
    val title: String
)