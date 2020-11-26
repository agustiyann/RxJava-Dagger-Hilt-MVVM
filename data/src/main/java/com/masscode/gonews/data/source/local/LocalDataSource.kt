package com.masscode.gonews.data.source.local

import com.masscode.gonews.data.source.local.entity.UserEntity
import com.masscode.gonews.data.source.local.room.UserDao
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) {

    fun getAllArticles(): Flowable<List<UserEntity>> = userDao.getAllArticles()

    fun insertArticles(userList: List<UserEntity>) = userDao.insertArticles(userList)
}