package com.findapple.presentation.di.module

import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.post.remote.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private val baseUrl = "https://"
        private val postUrl = "${baseUrl}/post"
        private val userUrl = "${baseUrl}/user"
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit.Builder): PostApi =
        retrofit.baseUrl(postUrl).build().create(PostApi::class.java)

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit.Builder): UserApi =
        retrofit.baseUrl(userUrl).build().create(UserApi::class.java)
}