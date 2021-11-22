package com.findapple.findapple.domain.features.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetRelatedLostPostUseCase(private val postService: PostService, compositeDisposable: CompositeDisposable): UseCase<String, Result<List<Post>>>(compositeDisposable) {
    override fun create(data: String): Single<Result<List<Post>>> =
        postService.getRelatedLostPost(data)
}