package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface LoginRepository {
    suspend fun saveLogin(login: String, password: String)
    suspend fun showUserCreds() : String
    suspend fun doesUserExist() : Boolean
    suspend fun logout()
}