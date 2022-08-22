package com.versec.versecko.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.versec.versecko.data.entity.UserEntity

@Dao
interface UserEntityDAO {

    /**
    @Query ("SELECT * FROM user " )
    fun getAllUser() : List<UserEntity>
    //List<UserEntity>

    @Query ("SELECT * FROM user WHERE uid = (:uid) ")
    fun getUser(uid : String) : UserEntity

    @Insert
    fun insertUser (user: UserEntity)

    @Query("DELETE FROM user WHERE uid = (:uid)")
    fun delete(uid : String) **/

    @Query ("SELECT * FROM user " )
    suspend fun getAllUser() : MutableList<UserEntity>

    @Query ("SELECT * FROM user WHERE uid = (:uid) ")
    suspend fun getUser(uid: String) :UserEntity

    @Insert (onConflict = REPLACE)
    suspend fun insertUser (user : UserEntity)

    @Query("DELETE FROM user WHERE uid = (:uid)")
    suspend fun delete(uid : String)


}