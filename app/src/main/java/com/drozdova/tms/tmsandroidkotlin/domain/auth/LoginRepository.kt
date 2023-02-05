package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface LoginRepository {
    suspend fun saveLogin(login: String, password: String)
    fun doesUserExist() : Boolean
    suspend fun logout()
    suspend fun saveUserInDB()
}