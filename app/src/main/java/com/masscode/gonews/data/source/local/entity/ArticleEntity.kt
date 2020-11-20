package com.masscode.gonews.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "date")
    val date: String
)