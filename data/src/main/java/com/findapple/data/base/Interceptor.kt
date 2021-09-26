package com.findapple.data.base

import com.findapple.data.local.sharedpref.LocalStorage
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