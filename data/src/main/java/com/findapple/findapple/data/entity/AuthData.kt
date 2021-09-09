package com.findapple.findapple.data.entity

import com.findapple.findapple.data.dto.request.LoginRequest
import com.findapple.findapple.domain.auth.entity.Auth

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
