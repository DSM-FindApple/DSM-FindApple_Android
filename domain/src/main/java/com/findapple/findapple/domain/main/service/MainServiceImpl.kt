package com.findapple.findapple.domain.main.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.main.repository.MainRepository
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class MainServiceImpl(
    private val mainRepository: MainRepository,
    private val errorHandler: ErrorHandler
) : MainService {
    override fun refreshToken(): Single<Result<Token>> =
        mainRepository.refreshToken().toResult(errorHandler)

}