package com.findapple.presentation.di.module

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
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit.Builder): PostApi =
        retrofit.baseUrl(postUrl).build().create(PostApi::class.java)
}