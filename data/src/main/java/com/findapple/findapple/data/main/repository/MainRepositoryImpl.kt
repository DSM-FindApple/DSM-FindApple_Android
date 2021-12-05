package com.findapple.findapple.data.main.repository

import com.findapple.findapple.data.features.auth.dto.response.toEntity
import com.findapple.findapple.data.main.datasource.MainDataSource
import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.features.auth.entity.Token
import com.findapple.findapple.domain.main.repository.MainRepository
import com.findapple.findapple.domain.toResult
import io.reactivex.Single
import com.findapple.findapple.domain.errorhandler.ErrorHandler

class MainRepositoryImpl(private val dataSource: MainDataSource, private val errorHandler: ErrorHandler) : MainRepository {
    override fun checkLogin(): Single<String> = dataSource.checkLogin()

    override fun refreshToken(): Single<Token> = dataSource.refreshToken().map { it.toEntity() }

    override fun getUserId(): Long =
        dataSource.getUserId()

    override fun getChatRoomId(id: Long): Single<Result<String>> =
        dataSource.getChatRoomId(id).toResult(errorHandler)
}