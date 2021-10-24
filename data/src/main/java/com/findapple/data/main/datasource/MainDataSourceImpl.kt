package com.findapple.data.main.datasource

import com.findapple.data.local.sharedpref.LocalStorage
import com.findapple.domain.entity.Location

class MainDataSourceImpl(private val localStorage: LocalStorage): MainDataSource {
    override fun saveLocation(location: Location) {
    }


}