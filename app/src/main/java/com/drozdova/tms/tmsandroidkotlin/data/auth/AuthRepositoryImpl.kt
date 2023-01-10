package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedpref.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {



















//            throw Exception()
            sharedPreferencesHelper.saveUserName(name = userName)
            sharedPreferencesHelper.saveUserPass(userPassword)
        }
    }

    override suspend fun showUserCreads(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.getUserCreads()
        }

    }

    override suspend fun doesUserExist(): Boolean {
       return withContext(Dispatchers.IO) {
           sharedPreferencesHelper.checkUserExists()
       }

    }

    override suspend fun UserLogout() {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.removeUser()
        }

    }


}