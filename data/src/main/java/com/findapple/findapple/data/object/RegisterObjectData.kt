package com.findapple.findapple.data.`object`

import com.findapple.findapple.data.dto.request.RegisterRequest
import com.findapple.findapple.domain.auth.`object`.RegisterObject

data class RegisterObjectData(
    var id: String,
    var nickname: String,
    var longitude: Long,
    var latitude: Long
)

fun RegisterObject.toDataEntity() =
    RegisterObjectData(
        id = auth.id,
        nickname = auth.nickname,
        longitude = locationInfo.longitude,
        latitude = locationInfo.latitude
    )

fun RegisterObjectData.toRegisterRequest() =
    RegisterRequest(
        kakaoId = id,
        kakaoNickName = nickname,
        longitude = longitude,
        latitude = latitude
    )