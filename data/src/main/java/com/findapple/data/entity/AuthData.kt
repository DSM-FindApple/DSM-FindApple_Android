package com.findapple.data.entity

import com.findapple.data.dto.request.LoginRequest
import com.findapple.domain.auth.entity.Auth

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
