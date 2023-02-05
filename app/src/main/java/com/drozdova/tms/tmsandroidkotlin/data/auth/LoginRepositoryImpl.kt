package com.drozdova.tms.tmsandroidkotlin.data.auth

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.data.database.LoginEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.LoginDAO
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.UsersDAO
import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val loginDAO: LoginDAO
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

    override suspend fun saveUserInDB() {
        withContext(Dispatchers.IO){
            val login = sharedPreferencesHelper.getLogin()
            val password = sharedPreferencesHelper.getPass()
            val loggedUser = LoginEntity(login = login, pass = password)
            if (login.isEmpty()) {
                Log.w("DATA", "no user.....")
            } else {
                Log.w("DATA", "${login} ${password}")
                loginDAO.saveLoginUser(loggedUser)
            }


        }
    }
}