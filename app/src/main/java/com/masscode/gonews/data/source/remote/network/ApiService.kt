package com.masscode.gonews.data.source.remote.network

import com.masscode.gonews.data.source.remote.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("test-api/users")
    fun getTopHeadlines(): Call<List<ArticleResponse>>
}