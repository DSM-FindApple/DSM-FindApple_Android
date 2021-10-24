package com.findapple.domain.main.repository

import com.findapple.domain.entity.Location
import io.reactivex.Single

interface MainRepository {
    fun saveLocation(location: Location): Single<Unit>
}