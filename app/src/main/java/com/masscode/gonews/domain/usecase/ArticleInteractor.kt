package com.masscode.gonews.domain.usecase

import com.masscode.gonews.domain.repository.IArticleRepository

class ArticleInteractor(private val articleRepository: IArticleRepository) : ArticleUseCase {
    override fun getAllArticles() = articleRepository.getAllArticles()
}