package com.findapple.presentation.data.local.sharedpref

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
        "Bearer" + getPref(context).getString(getTokenType(access), "").toString()

    override fun clearToken() {
        getPref(context).edit().clear().apply()
    }

    private fun getPref(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private fun getTokenType(access: Boolean) = if (access) "access" else "refresh"

}