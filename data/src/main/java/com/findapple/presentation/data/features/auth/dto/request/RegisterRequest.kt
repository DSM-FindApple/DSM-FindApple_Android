package com.findapple.presentation.data.features.auth.dto.request

import com.findapple.presentation.domain.features.auth.`object`.RegisterObject

data class RegisterRequest(
    val kakaoId: String,
    val kakaoNickName: String,
    val longitude: Double,
    val latitude: Double
)

fun RegisterObject.toRequest() =
    RegisterRequest(
        kakaoId = auth.id,
        kakaoNickName = auth.nickname,
        longitude = locationInfo.longitude,
        latitude = locationInfo.latitude
    )