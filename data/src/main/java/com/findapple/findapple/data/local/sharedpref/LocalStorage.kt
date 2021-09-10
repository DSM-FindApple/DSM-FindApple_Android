package com.findapple.findapple.data.local.sharedpref

interface LocalStorage {
    fun saveToken(token: String, access: Boolean)

    fun getToken(access: Boolean): String

    fun clearToken()
}