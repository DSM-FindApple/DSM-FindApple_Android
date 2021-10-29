package com.findapple.findapple.domain.main.repository

import com.findapple.findapple.domain.entity.Location
import io.reactivex.Single

interface MainRepository {
    fun saveLocation(location: Location): Single<Unit>
}