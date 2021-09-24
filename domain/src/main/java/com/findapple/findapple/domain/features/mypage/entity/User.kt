package com.findapple.findapple.domain.features.mypage.entity

data class User(
    val name: String,
    val lostPostCount: Int,
    val findPostCount: Int,
    val fineAppleLevel: Int
)