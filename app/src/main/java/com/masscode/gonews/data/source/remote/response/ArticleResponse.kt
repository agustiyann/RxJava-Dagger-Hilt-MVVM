package com.masscode.gonews.data.source.remote.response

import com.squareup.moshi.Json

data class ArticleResponse(
    @Json(name = "author")
    val author: String,

    @Json(name = "title")
    val title: String,

    @Json(name = "description")
    val description: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "urlToImage")
    val image: String,

    @Json(name = "publishedAt")
    val date: String
)