package com.findapple.data.features.auth.entity

import com.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.domain.features.auth.entity.Auth

data class AuthData(val id: String, val nickname: String, val deviceToken: String)

fun Auth.toDataEntity(deviceToken: String) =
    AuthData(
        id = id,
        nickname = nickname,
        deviceToken = deviceToken
    )

fun AuthData.toLoginRequest() =
    LoginRequest(
        kakaoId = id,
        kakaoNickName = nickname,
        deviceToken = deviceToken
    )
