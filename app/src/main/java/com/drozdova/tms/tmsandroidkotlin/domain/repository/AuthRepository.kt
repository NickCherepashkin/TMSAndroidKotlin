package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.model.UserModel

interface AuthRepository {
    fun loginUser(userName: String, userPassword: String)
    fun showUserCreads() : UserModel
    fun doesUserExist(): Boolean

    fun UserLogout()
}