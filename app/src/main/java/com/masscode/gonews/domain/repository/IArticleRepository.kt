package com.masscode.gonews.domain.repository

import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.Article
import io.reactivex.rxjava3.core.Flowable

interface IArticleRepository {
    fun getAllArticles(): Flowable<Resource<List<Article>>>
}