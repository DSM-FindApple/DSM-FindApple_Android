package com.findapple.domain.auth.request

import com.findapple.domain.base.Result
import com.findapple.domain.base.UseCase
import io.reactivex.Single

data class RegisterRequest(
    val kakaoId: String,
    val kakaoNickName: String,
    val longitude: Long,
    val latitude: Long
)