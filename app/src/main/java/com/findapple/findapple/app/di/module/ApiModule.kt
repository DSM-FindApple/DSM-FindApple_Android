package com.findapple.findapple.app.di.module

import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.features.mypage.remote.UserApi
import com.findapple.findapple.data.features.post.remote.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val baseUrl = "http://3.35.221.104:8080/"
        private const val postUrl = "${baseUrl}post/"
        private const val userUrl = "${baseUrl}user/"
        private const val authUrl = "${baseUrl}v1/"
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit.Builder): PostApi =
        retrofit.baseUrl(postUrl).build().create(PostApi::class.java)

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit.Builder): UserApi =
        retrofit.baseUrl(userUrl).build().create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit.Builder): AuthApi =
        retrofit.baseUrl(authUrl).build().create(AuthApi::class.java)
}