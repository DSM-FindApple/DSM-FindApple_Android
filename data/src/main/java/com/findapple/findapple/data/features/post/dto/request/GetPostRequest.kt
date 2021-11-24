package com.findapple.findapple.data.features.post.dto.request

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.post.parameter.GetPostParameter

data class GetPostRequest(val pageNum: Int, val location: Location)

fun GetPostParameter.toDataRequest() =
    GetPostRequest(
        pageNum,
        location
    )