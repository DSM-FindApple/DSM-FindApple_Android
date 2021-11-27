package com.findapple.findapple.domain.features.post.entity

import com.findapple.findapple.domain.entity.User

data class Comment(val user: User, val comment: String)