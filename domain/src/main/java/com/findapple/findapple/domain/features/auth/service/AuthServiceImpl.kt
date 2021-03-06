package com.findapple.findapple.domain.features.auth.service

import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.auth.parameter.LoginParameter
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : AuthService {
    override fun login(loginParameterData: LoginParameter): Single<Result<Token>> =
        authRepository.login(loginParameterData).toResult(errorHandler)
}