package com.findapple.domain.features.post.service

import com.findapple.domain.base.Result
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.post.`object`.PostDataObject
import com.findapple.domain.features.post.entity.Post
import com.findapple.domain.features.post.repository.PostRepository
import com.findapple.domain.toResult
import io.reactivex.Single

class PostServiceImpl(
    private val postRepository: PostRepository,
    private val errorHandler: ErrorHandler
) : PostService {
    override fun getPostList(isLostList: Boolean): Single<Result<List<Post>>> =
        postRepository.getPostList(isLostList).toResult(errorHandler)

    override fun postFeed(request: PostDataObject, isLost: Boolean): Single<Result<Unit>> =
        postRepository.postFeed(request, isLost).toResult(errorHandler)
}