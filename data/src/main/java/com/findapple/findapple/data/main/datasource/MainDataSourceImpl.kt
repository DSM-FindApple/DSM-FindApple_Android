package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.data.local.sharedpref.LocalStorage
import com.findapple.findapple.domain.entity.Location

class MainDataSourceImpl(private val localStorage: LocalStorage): MainDataSource {
    override fun saveLocation(location: Location) {
    }


}