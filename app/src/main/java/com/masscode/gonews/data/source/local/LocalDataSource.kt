package com.masscode.gonews.data.source.local

import androidx.lifecycle.LiveData
import com.masscode.gonews.data.source.local.entity.ArticleEntity
import com.masscode.gonews.data.source.local.room.ArticleDao

class LocalDataSource private constructor(private val articleDao: ArticleDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(articleDao: ArticleDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(articleDao)
            }
    }

    fun getAllArticles(): LiveData<List<ArticleEntity>> = articleDao.getAllArticles()

    fun insertArticles(articleList: List<ArticleEntity>) = articleDao.insertArticles(articleList)
}