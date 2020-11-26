package com.masscode.gonews.di.core

import com.masscode.gonews.data.UserRepository
import com.masscode.gonews.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(userRepository: UserRepository): com.masscode.gonews.domain.repository.IUserRepository
}