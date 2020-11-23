package com.masscode.gonews.data.source.remote

import com.masscode.gonews.data.source.remote.network.ApiResponse
import com.masscode.gonews.data.source.remote.network.ApiService
import com.masscode.gonews.data.source.remote.response.UserResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

class RemoteDatasource @Inject constructor(private val apiService: ApiService) {

    fun getAllArticles(): Flowable<ApiResponse<List<UserResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<UserResponse>>>()
        val client = apiService.getTopHeadlines()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                resultData.onNext(if (response.isNotEmpty()) ApiResponse.Success(response) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Timber.e(error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}