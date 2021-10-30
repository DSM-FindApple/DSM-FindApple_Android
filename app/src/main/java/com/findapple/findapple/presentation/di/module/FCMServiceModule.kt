package com.findapple.findapple.presentation.di.module

import com.findapple.findapple.presentation.features.fcm.FCMService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FCMServiceModule {
    @ContributesAndroidInjector
    abstract fun fcmService(): FCMService
}