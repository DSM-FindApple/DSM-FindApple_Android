package com.findapple.findapple.data.base

import com.findapple.findapple.data.local.localstorage.LocalStorage
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor(private val localStorage: LocalStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", localStorage.getToken(true))
            .build()
        return chain.proceed(request)
    }
}