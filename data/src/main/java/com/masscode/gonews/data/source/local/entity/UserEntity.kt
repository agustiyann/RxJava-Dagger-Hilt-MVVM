package com.masscode.gonews.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "job")
    val job: String,

    @ColumnInfo(name = "slogan")
    val slogan: String
)