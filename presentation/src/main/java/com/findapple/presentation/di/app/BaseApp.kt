package com.findapple.presentation.di.app

import com.findapple.data.local.sharedpref.LocalStorage
import com.findapple.presentation.R
import com.findapple.presentation.di.component.DaggerAppComponent
import com.kakao.sdk.common.KakaoSdk
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class BaseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()

    @Inject
    lateinit var localStorage: LocalStorage

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, resources.getString(R.string.onlyKey))
    }
}