package com.findapple.findapple.data.dto.response

import java.util.ArrayList

data class ImageResponse(
    val image: String
)

fun List<ImageResponse>.toStringList(): List<String> {
    val stringList = ArrayList<String>()
    for (i in this) {
        stringList.add(i.image)
    }
    return stringList
}