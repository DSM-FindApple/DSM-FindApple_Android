package com.findapple.presentation.domain.features.auth.service

import com.findapple.presentation.domain.features.auth.`object`.RegisterObject
import com.findapple.presentation.domain.features.auth.entity.Auth
import com.findapple.presentation.domain.features.auth.entity.Token
import com.findapple.presentation.domain.features.auth.repository.AuthRepository
import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.errorhandler.ErrorHandler
import com.findapple.presentation.domain.toResult
import io.reactivex.Single

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : AuthService {
    override fun login(loginRequestData: Auth): Single<Result<Token>> =
        authRepository.login(loginRequestData).toResult(errorHandler)

    override fun register(registerRequest: RegisterObject): Single<Result<Unit>> =
        authRepository.register(registerRequest).toResult(errorHandler)

    override fun refreshToken(): Single<Result<Unit>> =
        authRepository.refreshToken().toResult(errorHandler)
}