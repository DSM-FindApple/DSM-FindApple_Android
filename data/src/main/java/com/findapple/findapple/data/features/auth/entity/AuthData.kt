package com.findapple.findapple.data.features.auth.entity

import com.findapple.findapple.data.features.auth.dto.request.LoginRequest
import com.findapple.findapple.domain.features.auth.parameter.LoginParameter

data class AuthData(
    val id: Long,
    val nickname: String,
    val deviceToken: String,
    val latitude: Double,
    val longitude: Double
)

fun LoginParameter.toDataEntity(deviceToken: String) =
    AuthData(
        id = auth.id,
        nickname = auth.nickname,
        deviceToken = deviceToken,
        latitude = location.latitude!!,
        longitude = location.longitude!!
    )

fun AuthData.toLoginRequest() =
    LoginRequest(
        kakaoId = id,
        kakaoNickName = nickname,
        deviceToken = deviceToken,
        longitude = longitude,
        latitude = latitude
    )
