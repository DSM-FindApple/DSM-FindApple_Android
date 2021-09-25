package com.findapple.presentation.data.features.auth.dto.response

import com.findapple.presentation.domain.features.auth.entity.Token

data class LoginResponse(val accessToken: String, val refreshToken: String)

fun LoginResponse.toEntity() =
    Token(
        accessToken = accessToken,
        refreshToken = refreshToken
    )