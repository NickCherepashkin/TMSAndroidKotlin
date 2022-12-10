package com.drozdova.tms.tmsandroidkotlin.domain.repository

interface LoginRepository {
    fun saveLogin(login: String)
    fun getLogin() : String
}