package com.masscode.gonews.data

import com.masscode.gonews.data.source.local.LocalDataSource
import com.masscode.gonews.data.source.remote.RemoteDatasource
import com.masscode.gonews.data.source.remote.network.ApiResponse
import com.masscode.gonews.data.source.remote.response.ArticleResponse
import com.masscode.gonews.domain.model.Article
import com.masscode.gonews.domain.repository.IArticleRepository
import com.masscode.gonews.utils.AppExecutors
import com.masscode.gonews.utils.DataMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class ArticleRepository private constructor(
    private val remoteDatasource: RemoteDatasource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IArticleRepository {

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(
            remoteData: RemoteDatasource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): ArticleRepository =
            instance ?: synchronized(this) {
                instance ?: ArticleRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllArticles(): Flowable<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ArticleResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Article>> {
                return localDataSource.getAllArticles().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Article>?): Boolean =
                data == null || data.isEmpty()
//                true

            override fun createCall(): Flowable<ApiResponse<List<ArticleResponse>>> =
                remoteDatasource.getAllArticles()

            override fun saveCallResult(data: List<ArticleResponse>) {
                val articleList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertArticles(articleList).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

        }.asFlowable()
}