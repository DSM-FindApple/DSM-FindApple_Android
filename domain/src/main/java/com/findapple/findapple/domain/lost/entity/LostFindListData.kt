package com.findapple.findapple.domain.lost.entity

import java.util.*

data class LostFindListData(
    val id: Int,
    val title: String,
    val userName: String,
    val detailInfo: String,
    val actionTime: Date,
    val writeTime: Date,
    val category: String,
    val latitude: Long,
    val longitude: Long,
    val images: ListImage
)