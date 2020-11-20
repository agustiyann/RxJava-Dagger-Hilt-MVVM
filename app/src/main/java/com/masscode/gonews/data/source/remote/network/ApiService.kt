package com.masscode.gonews.data.source.remote.network

import com.masscode.gonews.data.source.remote.response.ListArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("apiKey") apiKey: String?,
        @Query("country") country: String?
    ): Call<ListArticleResponse>
}