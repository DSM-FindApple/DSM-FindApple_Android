package com.findapple.presentation.domain.features.post.service

import com.findapple.presentation.domain.base.Result
import com.findapple.presentation.domain.errorhandler.ErrorHandler
import com.findapple.presentation.domain.features.post.`object`.PostDataObject
import com.findapple.presentation.domain.features.post.entity.PostListData
import com.findapple.presentation.domain.features.post.repository.PostRepository
import com.findapple.presentation.domain.toResult
import io.reactivex.Single

class PostServiceImpl(
    private val postRepository: PostRepository,
    private val errorHandler: ErrorHandler
) : PostService {
    override fun getPostList(isLostList: Boolean): Single<Result<PostListData>> =
        postRepository.getPostList(isLostList).toResult(errorHandler)

    override fun postFeed(request: PostDataObject,isLost: Boolean): Single<Result<Unit>> =
        postRepository.postFeed(request,isLost).toResult(errorHandler)
}