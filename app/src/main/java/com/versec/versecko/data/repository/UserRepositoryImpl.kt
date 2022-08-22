package com.versec.versecko.data.repository

import com.versec.domain.model.UserModel
import com.versec.domain.repository.UserRepository
import com.versec.versecko.data.datasource.local.UserLocalDataSource
import com.versec.versecko.data.entity.UserEntity
import com.versec.versecko.data.mapper.UserMapper

class UserRepositoryImpl (
    private val localDataSource : UserLocalDataSource,
    //    private val remoteDataSource : UserRemoteDataSource
    private val userMapper: UserMapper

) :UserRepository
{

    override suspend fun getAllUser() : MutableList<UserModel>
    {
        val userList : List<UserEntity> = localDataSource.getAllUser()
        var temp = mutableListOf<UserModel>()


        for (user in userList)
            temp.add(userMapper.entityToModel(user))

        return temp
    }


    override suspend fun insertUser(userModel: UserModel) {

        return localDataSource.insertUser(userMapper.modelToEntity(userModel))
    }


}