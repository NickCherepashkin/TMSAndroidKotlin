package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreads() : UserModel {
        return authRepository.showUserCreads()
    }

    fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    fun logoutUser() {
        authRepository.UserLogout()
    }
}