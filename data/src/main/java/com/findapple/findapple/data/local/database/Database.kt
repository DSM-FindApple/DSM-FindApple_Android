package com.findapple.findapple.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.findapple.findapple.data.local.database.dao.UserDao
import com.findapple.findapple.data.local.database.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ], version = 1, exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
}