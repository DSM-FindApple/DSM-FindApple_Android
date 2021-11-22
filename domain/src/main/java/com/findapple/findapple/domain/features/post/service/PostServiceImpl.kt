package com.findapple.findapple.domain.features.post.service

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.post.parameter.PostDataParameter
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.repository.PostRepository
import com.findapple.findapple.domain.toResult
import io.reactivex.Single

class PostServiceImpl(
    private val postRepository: PostRepository,
    private val errorHandler: ErrorHandler
) : PostService {
    override fun getPostList(isLostList: Boolean): Single<Result<List<Post>>> =
        postRepository.getPostList(isLostList).toResult(errorHandler)

    override fun postFeed(request: PostDataParameter, isLost: Boolean): Single<Result<Unit>> =
        postRepository.postFeed(request, isLost).toResult(errorHandler)

    override fun getRelatedLostPost(title: String): Single<Result<List<Post>>> =
        postRepository.getRelatedLostPost(title).toResult(errorHandler)
}