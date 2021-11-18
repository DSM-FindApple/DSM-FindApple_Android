package com.findapple.findapple.data.features.auth.dto.request

data class LoginRequest(val kakaoId: Long, val kakaoNickName: String, val deviceToken: String, val latitude: Double, val longitude: Double, val profileUrl: String)