package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : LoginRepository {

    override suspend fun saveLogin(login: String, password: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveUserName(login)
            sharedPreferencesHelper.saveUserPass(password)
            sharedPreferencesHelper.setVisibilityOnBoarding(true)
        }
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override suspend fun logout() {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.logout()
            sharedPreferencesHelper.setVisibilityOnBoarding(true)
        }
    }
}