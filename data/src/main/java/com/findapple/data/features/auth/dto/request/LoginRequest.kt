package com.findapple.data.features.auth.dto.request

data class LoginRequest(val kakaoId: Long, val kakaoNickName: String, val deviceToken: String)