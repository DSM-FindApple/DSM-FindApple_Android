package com.findapple.findapple.data.features.mypage.dto.response

import com.findapple.findapple.domain.features.mypage.entity.UserDetail
import com.findapple.findapple.domain.features.post.entity.Post

data class UserResponse(
    val lostPostCount: Int,
    val findPostCount: Int,
    val findApplePoint: Int,
    val postList: List<Post>
)//todo 바뀔 수 있다

fun UserResponse.toEntity(): UserDetail =
    UserDetail(
        lostPostCount = lostPostCount,
        findPostCount = findPostCount,
        findAppleLevel = findApplePoint,
        postList
    )