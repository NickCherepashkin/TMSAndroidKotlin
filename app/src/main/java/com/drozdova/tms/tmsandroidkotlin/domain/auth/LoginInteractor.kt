package com.drozdova.tms.tmsandroidkotlin.domain.auth

import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val loginRepository: LoginRepository
)  {
    suspend fun saveLogin(login: String, password: String) {
        loginRepository.saveLogin(login, password)
    }

    suspend fun getUserCreds() : String{
        return loginRepository.showUserCreds()
    }

    suspend fun checkUserExists() : Boolean {
        return loginRepository.doesUserExist()
    }

    suspend fun logout() {
        loginRepository.logout()
    }
}