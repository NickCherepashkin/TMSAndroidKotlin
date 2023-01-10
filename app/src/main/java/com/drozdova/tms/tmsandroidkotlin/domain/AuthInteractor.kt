package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    suspend fun getUserCreads() : UserModel {
        return authRepository.showUserCreads()
    }

    suspend fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser() {
        authRepository.UserLogout()
    }
}