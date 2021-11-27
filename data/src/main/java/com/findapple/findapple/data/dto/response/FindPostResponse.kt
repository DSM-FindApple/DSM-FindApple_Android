package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.post.entity.Post

data class FindPostResponse (
    val category: String,
    val detail: String,
    val findAt: String,
    val findId: Long,
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

fun List<FindPostResponse>.toEntity(): List<Post> =
    this.map { it.toEntity() }

fun FindPostResponse.toEntity(): Post {
    return Post(
        id = findId,
        title = title,
        user = User(name = findUser, profileImage = profileUrl, id = kakaoId),
        detailInfo = detail,
        actionTime = findAt,
        writeTime = writeAt,
        category = category,
        location = Location(longitude, latitude),
        images = findImages,
        topComment = topComment.toEntity()
    )
}