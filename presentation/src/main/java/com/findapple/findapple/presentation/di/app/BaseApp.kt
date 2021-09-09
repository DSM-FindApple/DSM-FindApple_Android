package com.findapple.findapple.presentation.di.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }
}