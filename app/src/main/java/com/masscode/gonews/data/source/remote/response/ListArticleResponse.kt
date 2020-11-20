package com.masscode.gonews.data.source.remote.response

import com.squareup.moshi.Json

data class ListArticleResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResult: Int,
    @Json(name = "articles")
    val articles: List<ArticleResponse>
)