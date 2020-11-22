package com.masscode.gonews.domain.repository

import com.masscode.gonews.data.Resource
import com.masscode.gonews.domain.model.User
import io.reactivex.rxjava3.core.Flowable

interface IUserRepository {
    fun getAllArticles(): Flowable<Resource<List<User>>>
}