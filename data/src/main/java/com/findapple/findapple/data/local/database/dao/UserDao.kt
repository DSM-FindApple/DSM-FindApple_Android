package com.findapple.findapple.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.findapple.findapple.data.local.database.entity.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserData(info: UserEntity):Single<Unit>

    @Query("SELECT * FROM UserEntity WHERE id = :id")
    fun getUserData(id: Long): Single<UserEntity>

    @Query("DELETE FROM UserEntity")
    fun deleteUserData(): Single<Unit>
}