package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.model.UserModel

interface AuthRepository {
    suspend fun loginUser(userName: String, userPassword: String)
    suspend fun showUserCreads() : UserModel
    suspend fun doesUserExist(): Boolean

    suspend fun UserLogout()
}