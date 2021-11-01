package com.findapple.findapple.presentation.di.app

import com.findapple.findapple.R
import com.findapple.findapple.presentation.di.component.DaggerAppComponent
import com.kakao.sdk.common.KakaoSdk
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, resources.getString(R.string.onlyKey))
    }
}