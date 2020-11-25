package com.masscode.gonews.di.core

import android.content.Context
import androidx.room.Room
import com.masscode.gonews.data.source.local.room.UserDao
import com.masscode.gonews.data.source.local.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): UserDatabase = Room.databaseBuilder(
        context,
        UserDatabase::class.java, "Article.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.userDao()
}