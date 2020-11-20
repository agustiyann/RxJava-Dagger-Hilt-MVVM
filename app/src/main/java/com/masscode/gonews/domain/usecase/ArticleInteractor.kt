package com.masscode.gonews.domain.usecase

import androidx.lifecycle.LiveData
import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.Article
import com.masscode.gonews.domain.repository.IArticleRepository

class ArticleInteractor(private val articleRepository: IArticleRepository) : ArticleUseCase {
    override fun getAllArticles(): LiveData<Resource<List<Article>>> =
        articleRepository.getAllArticles()
}