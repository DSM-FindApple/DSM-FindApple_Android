package com.findapple.presentation.base

import androidx.lifecycle.Lifecycle

interface LifeCycleCallback {
    fun apply(event: Lifecycle.Event)
}