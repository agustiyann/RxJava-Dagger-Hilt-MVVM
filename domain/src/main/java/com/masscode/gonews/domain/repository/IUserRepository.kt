package com.masscode.gonews.domain.repository

import com.masscode.gonews.domain.model.User
import com.masscode.gonews.domain.usecase.Resource
import io.reactivex.rxjava3.core.Flowable

interface IUserRepository {
    fun getAllArticles(): Flowable<Resource<List<User>>>
}