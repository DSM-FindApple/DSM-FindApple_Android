package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.local.localstorage.LocalStorage
import io.reactivex.Single

class MainDataSourceImpl(private val localStorage: LocalStorage) : MainDataSource {
    override fun checkLogin(): Single<Boolean> =
        Single.just(localStorage.getString("access").isNotEmpty())
}