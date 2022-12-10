package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.domain.repository.LoginRepository

class LoginInteractor(private val loginRepository: LoginRepository)  {
    fun saveLogin(login: String) {
        loginRepository.saveLogin(login = login)
    }

    fun getLogin() : String{
        return loginRepository.getLogin()
    }
}