package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor

class LoginViewModel(private val loginInteractor: LoginInteractor) : ViewModel() {

    fun setName(name: String) {
        loginInteractor.saveLogin(name)
    }
}