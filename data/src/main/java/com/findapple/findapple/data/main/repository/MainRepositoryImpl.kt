package com.findapple.findapple.data.main.repository

import com.findapple.findapple.data.main.datasource.MainDataSource
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl(private val dataSource: MainDataSource) : MainRepository {
    override fun saveLocation(location: Location): Single<Unit> {
        TODO("Not yet implemented")
    }
}