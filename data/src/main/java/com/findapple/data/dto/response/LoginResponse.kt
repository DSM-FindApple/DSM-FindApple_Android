package com.findapple.data.dto.response

import com.findapple.domain.auth.entity.Auth
import com.findapple.domain.auth.entity.Token

data class LoginResponse(val accessToken: String, val refreshToken: String)

fun LoginResponse.toEntity() =
    Token(
        accessToken = accessToken,
        refreshToken = refreshToken
    )