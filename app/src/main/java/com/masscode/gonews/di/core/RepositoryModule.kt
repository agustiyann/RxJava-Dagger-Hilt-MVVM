package com.masscode.gonews.di.core

import com.masscode.gonews.data.UserRepository
import com.masscode.gonews.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(userRepository: UserRepository): IUserRepository
}