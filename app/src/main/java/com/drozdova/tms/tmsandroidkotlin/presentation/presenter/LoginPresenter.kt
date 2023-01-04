package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
){
    private lateinit var loginView: LoginView

    fun setLoginView(loginFragment: LoginFragment) {
        loginView = loginFragment
    }
    fun loginUser(userName: String, userPassword: String) {
        authInteractor.loginUser(userName, userPassword)
        loginView.loginUser()
    }
}