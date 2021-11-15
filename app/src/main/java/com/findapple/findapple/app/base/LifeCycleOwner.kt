package com.findapple.findapple.app.base

import androidx.lifecycle.Lifecycle

class LifeCycleOwner(private val lifeCycleCallback: LifeCycleCallback) {
    fun notifyEvent(event: Lifecycle.Event) {
        lifeCycleCallback.apply(event)
    }
}