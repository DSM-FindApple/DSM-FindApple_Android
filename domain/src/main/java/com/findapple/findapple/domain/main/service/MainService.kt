package com.findapple.findapple.domain.main.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.auth.entity.Token
import io.reactivex.Single

interface MainService {
    fun refreshToken(): Single<Result<Token>>
}