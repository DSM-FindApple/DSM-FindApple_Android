package com.findapple.findapple.data.main.datasource

import com.findapple.findapple.domain.entity.Location

interface MainDataSource {
    fun saveLocation(location: Location)
}