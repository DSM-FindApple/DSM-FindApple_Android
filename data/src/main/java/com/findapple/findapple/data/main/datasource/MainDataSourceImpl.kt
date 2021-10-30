package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.local.sharedpref.LocalStorage
import com.findapple.findapple.domain.entity.Location
import io.reactivex.Observable
import io.reactivex.Single

class MainDataSourceImpl(private val localStorage: LocalStorage) : MainDataSource {
    override fun checkLogin(): Single<Boolean> =
        Single.just(localStorage.getToken(true).isNotEmpty())
}