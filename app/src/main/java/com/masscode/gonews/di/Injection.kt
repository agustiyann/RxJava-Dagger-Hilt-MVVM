package com.masscode.gonews.di

import android.content.Context
import com.masscode.gonews.data.ArticleRepository
import com.masscode.gonews.data.source.local.LocalDataSource
import com.masscode.gonews.data.source.local.room.ArticleDatabase
import com.masscode.gonews.data.source.remote.RemoteDatasource
import com.masscode.gonews.data.source.remote.network.ApiConfig
import com.masscode.gonews.domain.repository.IArticleRepository
import com.masscode.gonews.domain.usecase.ArticleInteractor
import com.masscode.gonews.domain.usecase.ArticleUseCase
import com.masscode.gonews.utils.AppExecutors

object Injection {

    private fun provideRepository(context: Context): IArticleRepository {
        val database = ArticleDatabase.getInstance(context)
        val remoteDatasource = RemoteDatasource.getInstance(ApiConfig.provideApiService())
        val localDatasource = LocalDataSource.getInstance(database.articleDao())
        val appExecutors = AppExecutors()

        return ArticleRepository.getInstance(remoteDatasource, localDatasource, appExecutors)
    }

    fun provideArticleUseCase(context: Context): ArticleUseCase {
        val repository = provideRepository(context)
        return ArticleInteractor(repository)
    }
}