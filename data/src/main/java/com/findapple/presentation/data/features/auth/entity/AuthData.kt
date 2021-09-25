package com.findapple.presentation.data.features.auth.entity

import com.findapple.presentation.data.features.auth.dto.request.LoginRequest
import com.findapple.presentation.domain.features.auth.entity.Auth

data class AuthData(val id: String, var nickname: String)

fun Auth.toDataEntity() =
    AuthData(
        id = id,
        nickname = nickname
    )

fun AuthData.toLoginRequest() =
    LoginRequest(
        kakaoId = id,
        kakaoNickName = nickname
    )
