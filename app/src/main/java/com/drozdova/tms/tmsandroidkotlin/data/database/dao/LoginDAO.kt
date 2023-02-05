package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.drozdova.tms.tmsandroidkotlin.data.database.LoginEntity

@Dao
interface LoginDAO {
    @Insert
    fun saveLoginUser(loginEntity: LoginEntity)
}