package com.findapple.data.features.auth.entity

import com.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.domain.features.auth.entity.Auth

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
