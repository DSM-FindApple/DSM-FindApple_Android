package com.findapple.findapple.domain.main.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.main.repository.MainRepository
import io.reactivex.Single

class MainServiceImpl(private val mainRepository: MainRepository): MainService {
    override fun refreshToken(): Single<Result<Token>> {
        TODO("Not yet implemented")
    }
}