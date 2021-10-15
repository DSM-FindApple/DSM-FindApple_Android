package com.findapple.domain.features.mypage.service

import com.findapple.domain.base.Result
import com.findapple.domain.features.post.entity.Post
import io.reactivex.Single

interface UserService {
    fun getUserPostList(): Single<Result<List<Post>>>
}