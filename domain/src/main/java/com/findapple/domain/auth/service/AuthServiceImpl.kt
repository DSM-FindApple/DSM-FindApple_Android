package com.findapple.domain.auth.service

import com.findapple.domain.auth.`object`.RegisterObject
import com.findapple.domain.auth.entity.Auth
import com.findapple.domain.auth.entity.Token
import com.findapple.domain.auth.repository.AuthRepository
import com.findapple.domain.base.Result
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.toResult
import io.reactivex.Single

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : AuthService {
    override fun login(loginRequestData: Auth): Single<Result<Token>> =
        authRepository.login(loginRequestData).toResult(errorHandler)

    override fun register(registerRequest: RegisterObject): Single<Result<Unit>> =
        authRepository.register(registerRequest).toResult(errorHandler)
}