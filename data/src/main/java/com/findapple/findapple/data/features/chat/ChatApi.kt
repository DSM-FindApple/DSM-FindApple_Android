package com.findapple.findapple.data.features.chat

import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApi {
    @POST("chat/{kakaoId}")
    fun getChatRoomId(@Path("kakaoId") id: Long): Single<ChatRoomResponse>
}