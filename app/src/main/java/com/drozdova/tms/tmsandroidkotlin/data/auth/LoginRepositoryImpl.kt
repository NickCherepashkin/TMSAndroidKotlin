package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : LoginRepository {

    override suspend fun saveLogin(login: String, password: String) {
        sharedPreferencesHelper.saveUserName(login)
        sharedPreferencesHelper.saveUserPass(password)
        sharedPreferencesHelper.setVisibilityOnBoarding(true)
    }

    override fun showUserCreds() : String{
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun logout() {
        sharedPreferencesHelper.logout()
        sharedPreferencesHelper.setVisibilityOnBoarding(true)
    }

}