package com.drozdova.tms.tmsandroidkotlin.data.sharedprefs

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserName(name : String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPass(password : String?) {
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds() : String {
        return sharedPreferences.getString(USER_NAME, EMPTY_STRING) ?: "No user"
    }

    fun checkUserExists() : Boolean {
        val name = sharedPreferences.getString(USER_NAME, EMPTY_STRING)
        val password = sharedPreferences.getString(USER_PASSWORD, EMPTY_STRING)

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun logout() {
        saveUserName(null)
        saveUserPass(null)
    }

    fun setVisibilityOnBoarding(visibility: Boolean) {
        sharedPreferences.edit().putBoolean(ONBOARDING_IS_VISIBLE, visibility).apply()
    }

    fun isVisibleOnBoarding() : Boolean{
        return sharedPreferences.getBoolean(ONBOARDING_IS_VISIBLE, true)
    }

    companion object {
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"
        private const val EMPTY_STRING = ""
        private const val ONBOARDING_IS_VISIBLE = "IS_VISIBLE"
    }
}