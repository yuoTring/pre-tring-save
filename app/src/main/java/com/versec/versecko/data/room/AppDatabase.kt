package com.versec.versecko.data.room

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.versec.versecko.AppContext
import com.versec.versecko.data.entity.StoryEntity
import com.versec.versecko.data.entity.UserEntity

@Database(entities = [UserEntity::class, StoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userEntityDao() : UserEntityDAO

    companion object {
        private var database : AppDatabase ? = null
        lateinit private var context : Application

        fun getInstance () : AppDatabase {
            if (database == null)
            {
                if (context == null)
                    context = AppContext.getInstance()

                database = Room.databaseBuilder (
                    context,
                    AppDatabase::class.java,
                    "roomDB"
                ).build()
            }

            return database as AppDatabase
        }
    }
}