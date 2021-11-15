package com.findapple.findapple.app.base

import androidx.lifecycle.Lifecycle

interface LifeCycleCallback {
    fun apply(event: Lifecycle.Event)
}