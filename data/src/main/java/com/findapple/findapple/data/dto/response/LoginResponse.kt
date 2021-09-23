package com.findapple.findapple.data.dto.response

import com.findapple.findapple.domain.features.auth.entity.Token

data class LoginResponse(val accessToken: String, val refreshToken: String)

fun LoginResponse.toEntity() =
    Token(
        accessToken = accessToken,
        refreshToken = refreshToken
    )