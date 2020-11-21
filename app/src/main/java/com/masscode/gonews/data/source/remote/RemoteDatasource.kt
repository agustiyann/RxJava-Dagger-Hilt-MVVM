package com.masscode.gonews.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masscode.gonews.data.source.remote.network.ApiResponse
import com.masscode.gonews.data.source.remote.network.ApiService
import com.masscode.gonews.data.source.remote.response.ArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RemoteDatasource private constructor(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDatasource? = null

        fun getInstance(service: ApiService): RemoteDatasource =
            instance ?: synchronized(this) {
                instance ?: RemoteDatasource(service)
            }
    }

    fun getAllArticles(): LiveData<ApiResponse<List<ArticleResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<ArticleResponse>>>()
        val client = apiService.getTopHeadlines()

        client.enqueue(object : Callback<List<ArticleResponse>> {
            override fun onResponse(
                call: Call<List<ArticleResponse>>,
                response: Response<List<ArticleResponse>>
            ) {
                val dataArray = response.body()
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<List<ArticleResponse>>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Timber.e(t.message.toString())
            }
        })

        return resultData
    }
}