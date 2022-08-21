package com.versec.versecko.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.versec.domain.model.UserModel
import com.versec.domain.repository.UserRepository
import com.versec.domain.usecases.InsertUserUseCase
import com.versec.domain.usecases.GetUserUseCase
import com.versec.versecko.data.entity.UserEntity
import com.versec.versecko.data.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(



) : ViewModel()
{
    //lateinit var getUserUseCase: GetUserUseCase
    //lateinit var insertUserUseCase: InsertUserUseCase
    lateinit var userRepository: UserRepository


    val _user : LiveData<List<UserModel>> = liveData {

        val data = userRepository.getAllUser()

        emit(data)
        //val data = getUserUseCase.invoke()

        //emit(data)

    }



    //private val _userList = MutableLiveData<List<UserModel>>()


    fun insertUser (userModel: UserModel) {
        viewModelScope.launch(Dispatchers.IO) {
            //insertUserUseCase.invoke(userModel)

            userRepository.insertUser(userModel)
        }
    }



}