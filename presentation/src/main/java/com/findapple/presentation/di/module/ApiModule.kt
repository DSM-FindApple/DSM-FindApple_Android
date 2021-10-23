package com.findapple.presentation.di.module

import com.findapple.data.features.auth.remote.AuthApi
import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.post.remote.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private val baseUrl = "http://3.35.221.104:8080"
        private val postUrl = "${baseUrl}/post"
        private val userUrl = "${baseUrl}/user"
        private val authUrl = "${baseUrl}/v1/auth"
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