package com.masscode.gonews.domain.repository

import androidx.lifecycle.LiveData
import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.Article

interface IArticleRepository {
    fun getAllArticles(): LiveData<Resource<List<Article>>>
}