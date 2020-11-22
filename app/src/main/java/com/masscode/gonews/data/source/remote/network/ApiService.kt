package com.masscode.gonews.data.source.remote.network

import com.masscode.gonews.data.source.remote.response.UserResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("test-api/users")
    fun getTopHeadlines(): Flowable<List<UserResponse>>
}