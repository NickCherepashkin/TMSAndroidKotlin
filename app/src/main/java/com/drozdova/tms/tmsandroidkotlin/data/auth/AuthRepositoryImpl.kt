package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedpref.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(name = userName)
        sharedPreferencesHelper.saveUserPass(userPassword)
    }

    override fun showUserCreads(): UserModel {
        return sharedPreferencesHelper.getUserCreads()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun UserLogout() {
        sharedPreferencesHelper.removeUser()
    }


}