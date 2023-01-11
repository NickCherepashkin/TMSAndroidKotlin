package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface LoginRepository {
    suspend fun saveLogin(login: String, password: String)
    fun showUserCreds() : String
    fun doesUserExist() : Boolean
    fun logout()
}