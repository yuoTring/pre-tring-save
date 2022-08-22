package com.versec.versecko.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.versec.domain.model.UserModel
import com.versec.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (
    //var getUserUseCase: GetUserUseCase ,
    //var insertUserUseCase: InsertUserUseCase

    private val userRepository : UserRepository

): ViewModel()
{



    val _user : LiveData<MutableList<UserModel>> = liveData {

        val data = userRepository.getAllUser()

        Log.d("room-db-livedata", "livedata: "+ data.size)

        emit(data)
        //val data = getUserUseCase.invoke()

        //emit(data)

    }



    //private val _userList = MutableLiveData<List<UserModel>>()


    fun insertUser (userModel: UserModel) {
        viewModelScope.launch(Dispatchers.IO) {
            //insertUserUseCase.invoke(userModel)

            Log.d("room-db-livedata", "insert : livedata")

            userRepository.insertUser(userModel)
        }
    }



}