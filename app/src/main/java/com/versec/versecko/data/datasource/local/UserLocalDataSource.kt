package com.versec.versecko.data.datasource.local

import com.versec.versecko.data.entity.UserEntity

interface UserLocalDataSource {
    suspend fun getAllUser () : MutableList<UserEntity>
    suspend fun insertUser (userEntity: UserEntity)
}