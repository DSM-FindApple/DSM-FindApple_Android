package com.findapple.findapple.data.dto.request

import com.findapple.findapple.domain.auth.`object`.RegisterObject

data class RegisterRequest(
    val kakaoId: String,
    val kakaoNickName: String,
    val longitude: Long,
    val latitude: Long
)

fun RegisterObject.toRequest() =
    RegisterRequest(
        kakaoId = auth.id,
        kakaoNickName = auth.nickname,
        longitude = locationInfo.longitude,
        latitude = locationInfo.latitude
    )