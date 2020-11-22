package com.masscode.gonews.di

import android.content.Context
import com.masscode.gonews.data.UserRepository
import com.masscode.gonews.data.source.local.LocalDataSource
import com.masscode.gonews.data.source.local.room.ArticleDatabase
import com.masscode.gonews.data.source.remote.RemoteDatasource
import com.masscode.gonews.data.source.remote.network.ApiConfig
import com.masscode.gonews.domain.repository.IUserRepository
import com.masscode.gonews.domain.usecase.UserInteractor
import com.masscode.gonews.domain.usecase.UserUseCase
import com.masscode.gonews.utils.AppExecutors

object Injection {

    private fun provideRepository(context: Context): IUserRepository {
        val database = ArticleDatabase.getInstance(context)
        val remoteDatasource = RemoteDatasource.getInstance(ApiConfig.provideApiService())
        val localDatasource = LocalDataSource.getInstance(database.articleDao())
        val appExecutors = AppExecutors()

        return UserRepository.getInstance(remoteDatasource, localDatasource, appExecutors)
    }

    fun provideArticleUseCase(context: Context): UserUseCase {
        val repository = provideRepository(context)
        return UserInteractor(repository)
    }
}