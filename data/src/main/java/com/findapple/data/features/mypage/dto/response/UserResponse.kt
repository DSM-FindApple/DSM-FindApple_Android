package com.findapple.data.features.mypage.dto.response

import com.findapple.domain.features.mypage.entity.UserDetail

data class UserResponse(
    val lostPostCount: Int,
    val findPostCount: Int,
    val findApplePoint: Int
)//todo 바뀔 수 있다

fun UserResponse.toEntity(): UserDetail =
    UserDetail(
        lostPostCount = lostPostCount,
        findPostCount = findPostCount,
        findAppleLevel = findApplePoint
    )