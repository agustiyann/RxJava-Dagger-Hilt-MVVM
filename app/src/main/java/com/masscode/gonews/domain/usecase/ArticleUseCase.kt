package com.masscode.gonews.domain.usecase

import androidx.lifecycle.LiveData
import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.Article

interface ArticleUseCase {
    fun getAllArticles(): LiveData<Resource<List<Article>>>
}