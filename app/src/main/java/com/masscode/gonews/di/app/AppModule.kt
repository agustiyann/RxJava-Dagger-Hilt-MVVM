package com.masscode.gonews.di.app

import com.masscode.gonews.domain.usecase.UserInteractor
import com.masscode.gonews.domain.usecase.UserUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideUserUseCase(userInteractor: UserInteractor): UserUseCase
}