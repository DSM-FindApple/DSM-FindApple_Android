package com.findapple.findapple.domain.features.mypage.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class UserServiceImpl(
    private val repository: UserRepository,
    private val errorHandler: ErrorHandler
) : UserService {
    override fun getUserPostList(): Single<Result<List<Post>>> =
        repository.userPostList().toResult(errorHandler)
}