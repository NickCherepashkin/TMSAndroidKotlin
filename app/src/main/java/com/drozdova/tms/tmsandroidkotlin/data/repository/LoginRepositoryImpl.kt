package com.drozdova.tms.tmsandroidkotlin.data.repository

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.domain.repository.LoginRepository

private const val SHARED_PREFS_FILE = "app_file"
private const val KEY_NAME = "name"

class LoginRepositoryImpl(context: Context) : LoginRepository {

    private val file = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

    override fun saveLogin(login: String) {
        file.edit().putString(KEY_NAME, login).apply()
    }

    override fun getLogin() : String{
        return file.getString(KEY_NAME, "") ?: ""
    }

}