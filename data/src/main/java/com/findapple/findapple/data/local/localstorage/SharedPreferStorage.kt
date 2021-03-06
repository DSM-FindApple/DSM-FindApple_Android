package com.findapple.findapple.data.local.localstorage

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPreferStorage(private val context: Context) : LocalStorage {
    override fun saveToken(token: String, access: Boolean) {
        getPref(context).edit().let {
            it.putString(getTokenType(access), token)
            it.apply()
        }
    }


    override fun getToken(access: Boolean): String =
        getPref(context).getString(getTokenType(access), "").toString()

    override fun clearToken() {
        getPref(context).edit().clear().apply()
    }

    override fun saveString(key: String, content: String) {
        getPref(context).edit().let {
            it.putString(key, content)
            it.apply()
        }
    }

    override fun getString(key: String): String =
        getPref(context).getString(key, "").toString()

    override fun saveLong(key: String, data: Long) {
        getPref(context).edit().let {
            it.putLong(key, data)
            it.apply()
        }
    }

    override fun getLong(key: String): Long =
        getPref(context).getLong(key, 1)

    private fun getPref(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private fun getTokenType(access: Boolean) = if (access) "access" else "refresh"

}