package com.findapple.findapple.data.features.mypage.dto.response

import com.findapple.findapple.data.dto.response.LostPostResponse

data class UserResponse(
    val findNum: Int,
    val lostNum: Int,
    val kakaoId: Int,
    val findapplePoint: Int,
    val myLosts: List<LostPostResponse>,
    val nickName: String,
    val profileUrl: String
)
