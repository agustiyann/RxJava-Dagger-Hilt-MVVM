package com.masscode.gonews.data.utils

import com.masscode.gonews.data.source.local.entity.UserEntity
import com.masscode.gonews.data.source.remote.response.UserResponse
import com.masscode.gonews.domain.model.User

object DataMapper {

    fun mapResponsesToEntities(input: List<UserResponse>): List<UserEntity> {
        val articleList = ArrayList<UserEntity>()
        input.map {
            val article = UserEntity(
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

    fun mapEntitiesToDomain(input: List<UserEntity>): List<User> =
        input.map {
            User(
                id = it.id,
                username = it.username,
                avatar = it.avatar,
                job = it.job,
                slogan = it.slogan
            )
        }

    fun mapDomainToEntity(input: User) = UserEntity(
        id = input.id,
        username = input.username,
        avatar = input.avatar,
        job = input.job,
        slogan = input.slogan
    )
}