package com.versec.versecko.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class UserTestActivity : AppCompatActivity()
{
    private val userViewModel : UserViewModel by viewModel<UserViewModel>()

    private lateinit var  button : AppCompatButton

    //lateinit var binding: ActivityUserTestBinding

    private var count : Int =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_test)

        //userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        button = findViewById(R.id.testButton)

        //binding = DataBindingUtil.setContentView(this, R.layout.activity_user_test)
        //binding.user = UserEntity()


        val userObserver = Observer<MutableList<UserModel>> { newUserList ->

            Toast.makeText(this, "called: "+newUserList.size, Toast.LENGTH_SHORT).show()

            Log.d("room-db-status", "size: "+newUserList.size)


        }

        userViewModel._user.observe(this, userObserver)



        button.setOnClickListener(View.OnClickListener {


            count++
            Toast.makeText(this, "updated: "+count, Toast.LENGTH_SHORT).show()

            userViewModel.insertUser(UserModel(
                uid = count.toString(),
                nickName = "Alexar",
                gender ="female",
                age = 22,
                birth ="19990901",
                mainResidence= "Seoul",
                subResidence = "???",
                tripWish = mutableListOf("!!!","!!?"),
                tripStyle = mutableListOf("!!!","!!?"),
                selfIntroduction = "hi -_-",
                uriList = mutableListOf("!!!","!!?"),
                geohash = "none",
                latitude = 37.455,
                longitude = 124.890,
                mannerScore = 4.5,
                premiumOrNot = false,
                knock = 0
            ))

        })
    }


}