package com.findapple.findapple.app.features.fcm

import com.findapple.findapple.data.local.localstorage.LocalStorage
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import javax.inject.Inject

class FCMService : FirebaseMessagingService() {
    @Inject
    lateinit var localStorage: LocalStorage

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        localStorage.saveString("device_token", p0)
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        //todo 메세지 받았을때
    }
}