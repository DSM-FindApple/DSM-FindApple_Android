package com.findapple.findapple.app.di.module

import com.findapple.findapple.data.features.auth.remote.AuthApi
import com.findapple.findapple.data.features.comment.remote.CommentApi
import com.findapple.findapple.data.features.mypage.remote.UserApi
import com.findapple.findapple.data.features.post.remote.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val baseUrl = "https://api.find-apple.org/"
        private const val postUrl = "${baseUrl}post/"
        private const val userUrl = baseUrl
        private const val authUrl = "${baseUrl}v1/"
        private const val commentUrl = "${baseUrl}comment/"
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

    @Provides
    @Singleton
    fun provideCommentApi(retrofit: Retrofit.Builder): CommentApi =
        retrofit.baseUrl(commentUrl).build().create(CommentApi::class.java)
}