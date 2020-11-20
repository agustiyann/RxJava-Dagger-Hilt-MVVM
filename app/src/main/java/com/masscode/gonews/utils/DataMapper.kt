package com.masscode.gonews.utils

import com.masscode.gonews.data.source.local.entity.ArticleEntity
import com.masscode.gonews.data.source.remote.response.ArticleResponse
import com.masscode.gonews.domain.model.Article

object DataMapper {

    fun mapResponsesToEntities(input: List<ArticleResponse>): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                title = it.title,
                author = it.author,
                description = it.description,
                url = it.url,
                image = it.image,
                date = it.date
            )
            articleList.add(article)
        }
        return articleList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
        input.map {
            Article(
                title = it.title,
                author = it.author,
                description = it.description,
                url = it.url,
                image = it.image,
                date = it.date
            )
        }

    fun mapDomainToEntity(input: Article) = ArticleEntity(
        title = input.title,
        author = input.author,
        description = input.description,
        url = input.url,
        image = input.image,
        date = input.date
    )
}