package com.findapple.findapple.domain.features.post.usecase

import com.findapple.findapple.domain.base.Result
import com.findapple.findapple.domain.base.UseCase
import com.findapple.findapple.domain.features.post.entity.Post
import com.findapple.findapple.domain.features.post.service.PostService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetFindListUseCase(
    private val postService: PostService,
    compositeDisposable: CompositeDisposable
) :
    UseCase<Int, Result<List<Post>>>(compositeDisposable) {
    override fun create(data: Int): Single<Result<List<Post>>> =
        postService.getPostList(data,false)
}