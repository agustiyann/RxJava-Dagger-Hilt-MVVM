package com.masscode.gonews.domain.usecase

import com.masscode.gonews.domain.repository.IUserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: IUserRepository) : UserUseCase {
    override fun getAllArticles() = userRepository.getAllArticles()
}