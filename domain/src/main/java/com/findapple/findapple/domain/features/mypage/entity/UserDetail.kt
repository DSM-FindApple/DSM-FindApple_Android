package com.findapple.findapple.domain.features.mypage.entity

import com.findapple.findapple.domain.features.post.entity.Post

data class UserDetail(
    val lostPostCount: Int,
    val findPostCount: Int,
    val findAppleLevel: Int,
    val postedList: List<Post>?
)