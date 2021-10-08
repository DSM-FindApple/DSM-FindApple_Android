package com.findapple.data.local.database

import androidx.room.Database
import com.findapple.data.local.database.dao.UserDao
import com.findapple.data.local.database.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ], version = 1, exportSchema = false
)
abstract class Database {
    abstract val userDao: UserDao
}