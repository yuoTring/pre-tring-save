package com.versec.versecko.data.datasource.local

import com.versec.versecko.data.entity.UserEntity
import com.versec.versecko.data.room.AppDatabase

class UserLocalDataSourceImpl : UserLocalDataSource {

    lateinit private var appDatabase: AppDatabase

    override suspend fun getAllUser(): List<UserEntity> {

        appDatabase = AppDatabase.getInstance()

        return appDatabase.userEntityDao().getAllUser()
    }

    override suspend fun insertUser(userEntity: UserEntity) {
        appDatabase = AppDatabase.getInstance()

        appDatabase.userEntityDao().insertUser(userEntity)
        TODO("Not yet implemented")
    }
}