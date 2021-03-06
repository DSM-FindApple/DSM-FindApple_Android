package com.findapple.findapple.data.local.localstorage

interface LocalStorage {
    fun saveToken(token: String, access: Boolean)

    fun getToken(access: Boolean): String

    fun clearToken()

    fun saveString(key: String, content: String)

    fun getString(key: String): String

    fun saveLong(key: String, data: Long)

    fun getLong(key: String): Long
}