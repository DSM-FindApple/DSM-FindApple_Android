package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.features.auth.dto.response.LoginResponse
import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.features.chat.ChatApi
import com.findapple.findapple.data.local.localstorage.LocalStorage
import io.reactivex.Single

class MainDataSourceImpl(private val localStorage: LocalStorage, private val authApi: AuthApi, private val chatApi: ChatApi) :
    MainDataSource {
    override fun checkLogin(): Single<String> =
        Single.just(localStorage.getString("access"))

    override fun refreshToken(): Single<LoginResponse> =
        authApi.refreshToken(localStorage.getToken(false)).map {
            localStorage.run {
                saveToken(it.accessToken, true)
                saveToken(it.refreshToken, false)
            }
            it
        }

    override fun getUserId(): Long =
        localStorage.getLong("user_id")

    override fun getChatRoomId(id: Long): Single<String> =
        chatApi.getChatRoomId(id).map { it.chatId }

}