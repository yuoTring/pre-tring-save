package com.versec.versecko.data.datasource.local

import com.versec.versecko.data.entity.UserEntity
import com.versec.versecko.data.room.AppDatabase

class UserLocalDataSourceImpl(

    private val appDatabase: AppDatabase

) : UserLocalDataSource {


    override suspend fun getAllUser() : MutableList<UserEntity> {


        return appDatabase.userEntityDao().getAllUser()
    }

    override suspend fun insertUser(userEntity: UserEntity) {

        appDatabase.userEntityDao().insertUser(userEntity)
    }
}