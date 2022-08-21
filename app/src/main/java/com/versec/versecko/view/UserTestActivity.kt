package com.versec.versecko.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.versec.domain.model.UserModel
import com.versec.versecko.R
import com.versec.versecko.data.entity.UserEntity
import com.versec.versecko.databinding.ActivityUserTestBinding
import com.versec.versecko.viewmodel.UserViewModel
import java.util.*

class UserTestActivity : AppCompatActivity()
{
    private lateinit var userViewModel : UserViewModel

    private lateinit var  button : AppCompatButton

    //lateinit var binding: ActivityUserTestBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_test)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        button = findViewById(R.id.testButton)

        //binding = DataBindingUtil.setContentView(this, R.layout.activity_user_test)
        //binding.user = UserEntity()


        val userObserver = Observer<List<UserModel>> { newUserList ->

            Toast.makeText(this, newUserList.size, Toast.LENGTH_LONG).show()

        }

        userViewModel._user.observe(this, userObserver)



        button.setOnClickListener(View.OnClickListener {

            userViewModel.insertUser(UserModel())

        })
    }


}