package com.findapple.data.features.mypage.dto.response

import com.findapple.domain.features.mypage.entity.User

data class UserResponse(
    val userName: String,
    val lostPostCount: Int,
    val findPostCount: Int,
    val findApplePoint: Int
)//todo 바뀔 수 있다

fun UserResponse.toEntity(): User =
    User(
        name = userName,
        lostPostCount = lostPostCount,
        findPostCount = findPostCount,
        fineAppleLevel = findApplePoint
    )