package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.data.repository.LoginRepositoryImpl

class LoginInteractor(private val loginRepository: LoginRepositoryImpl)  {
    fun saveLogin(login: String) {
        loginRepository.saveLogin(login = login)
    }
}