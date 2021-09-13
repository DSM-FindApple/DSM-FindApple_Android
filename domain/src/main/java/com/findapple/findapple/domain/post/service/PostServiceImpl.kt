package com.findapple.findapple.domain.post.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.post.entity.PostListData
import com.findapple.findapple.domain.post.repository.PostRepository
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class PostServiceImpl(
    private val postRepository: PostRepository,
    private val errorHandler: ErrorHandler
) : PostService {
    override fun getPostList(isLostList: Boolean): Single<Result<PostListData>> =
        postRepository.getPostList(isLostList).toResult(errorHandler)
}