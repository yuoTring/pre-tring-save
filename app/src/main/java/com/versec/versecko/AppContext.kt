package com.versec.versecko

import android.app.Application

class AppContext : Application() {

    companion object{
        lateinit var appContext : Application

        fun getInstance() : Application {
            if (appContext == null)
                AppContext.appContext = Application().applicationContext as Application


            return AppContext.appContext
        }
    }
}