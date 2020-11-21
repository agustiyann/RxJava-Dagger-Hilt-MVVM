package com.masscode.gonews.utils

import com.masscode.gonews.data.source.local.entity.ArticleEntity
import com.masscode.gonews.data.source.remote.response.ArticleResponse
import com.masscode.gonews.domain.model.Article

object DataMapper {

    fun mapResponsesToEntities(input: List<ArticleResponse>): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                id = it.id,
                username = it.username,
                avatar = it.avatar,
                job = it.job,
                slogan = it.slogan
            )
            articleList.add(article)
        }
        return articleList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
        input.map {
            Article(
                id = it.id,
                username = it.username,
                avatar = it.avatar,
                job = it.job,
                slogan = it.slogan
            )
        }

    fun mapDomainToEntity(input: Article) = ArticleEntity(
        id = input.id,
        username = input.username,
        avatar = input.avatar,
        job = input.job,
        slogan = input.slogan
    )
}