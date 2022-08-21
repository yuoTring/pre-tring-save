package com.versec.domain.repository

import com.versec.domain.model.UserModel

interface UserRepository {

    //suspend fun getUser(uid : String) : User
    suspend fun getAllUser () : List<UserModel>
    suspend fun insertUser (userModel: UserModel)

}