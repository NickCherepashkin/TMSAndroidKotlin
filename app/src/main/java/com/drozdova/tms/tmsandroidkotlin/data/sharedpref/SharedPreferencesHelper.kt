package com.drozdova.tms.tmsandroidkotlin.data.sharedpref

import android.content.SharedPreferences
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }
    fun saveUserPass(pass: String?) {
        sharedPreferences.edit().putString(USER_PASS, pass).apply()
    }

    fun getUserCreads() : UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: "No user"
        val pass = sharedPreferences.getString(USER_PASS, "") ?: "No user"
        return UserModel(name, pass)
    }

    fun checkUserExists() : Boolean {
        val name = sharedPreferences.getString(USER_NAME, "")
        val pass = sharedPreferences.getString(USER_PASS, "")
        return (!name.isNullOrEmpty() && !pass.isNullOrEmpty())
    }

    fun removeUser() {
        saveUserName(null)
        saveUserPass(null)
    }

    companion object {
        const val USER_NAME = "name"
        const val USER_PASS = "pass"
    }


}