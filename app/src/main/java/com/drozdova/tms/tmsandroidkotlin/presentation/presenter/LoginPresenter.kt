package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginPresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
) {
    private lateinit var loginView: LoginView

    fun setLoginView(loginView : LoginView) {
        this.loginView = loginView
    }

    fun loginPresent(login: String, password: String){
        loginInteractor.saveLogin(login, password)
        loginView.login()
    }


}