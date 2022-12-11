package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor

class LoginModelFactory(val loginInteractor: LoginInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginInteractor) as T
    }
}