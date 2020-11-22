package com.masscode.gonews.data.source.local

import com.masscode.gonews.data.source.local.entity.UserEntity
import com.masscode.gonews.data.source.local.room.UserDao
import io.reactivex.rxjava3.core.Flowable

class LocalDataSource private constructor(private val userDao: UserDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(userDao: UserDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(userDao)
            }
    }

    fun getAllArticles(): Flowable<List<UserEntity>> = userDao.getAllArticles()

    fun insertArticles(userList: List<UserEntity>) = userDao.insertArticles(userList)
}