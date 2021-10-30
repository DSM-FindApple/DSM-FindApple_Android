package com.findapple.findapple.data.main.datasource

import io.reactivex.Single

interface MainDataSource {
    fun checkLogin(): Single<Boolean>
}