package com.findapple.data.main.datasource

import com.findapple.domain.entity.Location

interface MainDataSource {
    fun saveLocation(location: Location)
}