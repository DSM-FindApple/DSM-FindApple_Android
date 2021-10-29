package com.findapple.findapple.domain

import org.junit.Before
import org.junit.ClassRule
import org.mockito.MockitoAnnotations

open class BaseTest {
    companion object {
        @ClassRule
        @JvmField
        val scheduler = RxSchedulerRule()
    }

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
}