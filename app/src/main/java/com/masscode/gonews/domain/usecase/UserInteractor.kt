package com.masscode.gonews.domain.usecase

import com.masscode.gonews.domain.repository.IUserRepository

class UserInteractor(private val userRepository: IUserRepository) : UserUseCase {
    override fun getAllArticles() = userRepository.getAllArticles()
}