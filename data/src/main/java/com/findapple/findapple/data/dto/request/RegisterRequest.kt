package com.findapple.findapple.data.dto.request

data class RegisterRequest(
    val kakaoId: String,
    val kakaoNickName: String,
    val longitude: Long,
    val latitude: Long
)