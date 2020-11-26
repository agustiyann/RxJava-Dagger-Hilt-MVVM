package com.masscode.gonews.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.masscode.gonews.data.source.local.entity.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllArticles(): Flowable<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(users: List<UserEntity>): Completable
}