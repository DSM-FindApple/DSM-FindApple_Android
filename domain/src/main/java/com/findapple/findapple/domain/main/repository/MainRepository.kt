package com.findapple.findapple.domain.main.repository

import io.reactivex.Single

interface MainRepository {
    fun checkLogin(): Single<Boolean>

    fun refreshToken(): Single<Unit>
}