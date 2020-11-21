package com.masscode.gonews.domain.usecase

import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.Article
import io.reactivex.rxjava3.core.Flowable

interface ArticleUseCase {
    fun getAllArticles(): Flowable<Resource<List<Article>>>
}