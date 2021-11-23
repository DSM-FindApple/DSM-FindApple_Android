package com.findapple.findapple.data.features.post.dto.response

import com.findapple.findapple.data.dto.response.TopCommentResponse
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post

data class FindListResponse(
    val category: String,
    val detail: String,
    val findAt: String,
    val findId: Int,
    val findImages: List<String>,
    val findUser: String,
    val kakaoId: Long,
    val latitude: Double,
    val longitude: Double,
    val profileUrl: String,
    val title: String,
    val topComment: TopCommentResponse,
    val writeAt: String
)

fun List<FindListResponse>.toEntity(): List<Post> =
    this.map { it.toEntity() }

fun FindListResponse.toEntity(): Post {
    return Post(
        id = findId,
        title = title,
        user = User(name = findUser, profileImage = profileUrl, id = kakaoId),
        detailInfo = detail,
        actionTime = findAt,
        writeTime = writeAt,
        category = category,
        location = Location(longitude, latitude),
        images = findImages
    )
}
