package com.findapple.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.findapple.domain.entity.User

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val profileImageUrl: String
)

fun UserEntity.toEntity() =
    User(
        id = id,
        name = name,
        profileImage = profileImageUrl
    )

fun User.toDatabaseEntity() =
    UserEntity(
        id = id,
        name = name,
        profileImageUrl = profileImage
    )