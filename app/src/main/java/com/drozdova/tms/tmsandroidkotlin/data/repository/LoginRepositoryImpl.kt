package com.drozdova.tms.tmsandroidkotlin.data.repository

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.domain.repository.LoginRepository
import com.drozdova.tms.tmsandroidkotlin.utils.SharedPrefConstants

class LoginRepositoryImpl(context: Context) : LoginRepository {

    private val file = context.getSharedPreferences(SharedPrefConstants.SHARED_PREFS_FILE, Context.MODE_PRIVATE)

    override fun saveLogin(login: String) {
        file.edit().putString(SharedPrefConstants.KEY_NAME, login).apply()
    }

}