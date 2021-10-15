package com.findapple.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.findapple.data.local.database.entity.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserData(info: UserEntity):Single<Unit>

    @Query("SELECT * FROM UserEntity")
    fun getUserData(): Single<UserEntity>
}