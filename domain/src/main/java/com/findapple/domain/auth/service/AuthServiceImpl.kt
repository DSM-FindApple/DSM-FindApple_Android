package com.findapple.domain.auth.service

import com.findapple.domain.auth.repository.AuthRepository
import com.findapple.domain.auth.request.LoginRequest
import com.findapple.domain.auth.request.RegisterRequest
import com.findapple.domain.auth.response.LoginResponse
import com.findapple.domain.base.Result
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.toResult
import io.reactivex.Single

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : AuthService {
    override fun login(loginRequestData: LoginRequest): Single<Result<LoginResponse>> =
        authRepository.login(loginRequestData).toResult(errorHandler)

    override fun register(registerRequest: RegisterRequest): Single<Result<Unit>> =
        authRepository.register(registerRequest).toResult(errorHandler)
}