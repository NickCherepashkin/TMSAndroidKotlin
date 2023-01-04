package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface LoginRepository {
    fun saveLogin(login: String, password: String)
    fun showUserCreds() : String
    fun doesUserExist() : Boolean
    fun logout()
}