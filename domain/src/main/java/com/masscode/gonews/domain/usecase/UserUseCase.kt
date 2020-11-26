package com.masscode.gonews.domain.usecase

import com.masscode.gonews.domain.model.User
import io.reactivex.rxjava3.core.Flowable

interface UserUseCase {
    fun getAllArticles(): Flowable<Resource<List<User>>>
}