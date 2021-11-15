package com.findapple.findapple.app.di.module

import com.findapple.findapple.app.features.fcm.FCMService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FCMServiceModule {
    @ContributesAndroidInjector
    abstract fun fcmService(): FCMService
}