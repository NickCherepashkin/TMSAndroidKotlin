package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor

class LoginPresenter (
    private val loginView: LoginView,
    private val loginInteractor: LoginInteractor
) {

    fun loginPresent(name: String){
        loginInteractor.saveLogin(name)
        loginView.login()
    }
}