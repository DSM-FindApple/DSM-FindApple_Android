package com.findapple.findapple.data.features.mypage.dto.response

import com.findapple.findapple.data.dto.response.LostPostResponse
import com.findapple.findapple.data.dto.response.toEntity
import com.findapple.findapple.domain.features.mypage.entity.UserDetail

data class UserResponse(
    val findNum: Int,
    val lostNum: Int,
    val kakaoId: Int,
    val findapplePoint: Int,
    val myLosts: List<LostPostResponse>,
    val nickName: String,
    val profileUrl: String
)

fun UserResponse.toEntity() =
    UserDetail(
        lostPostCount = lostNum,
        findPostCount = findNum,
        findAppleLevel = findapplePoint,
        postedList = myLosts.map { it.toEntity() }
    )