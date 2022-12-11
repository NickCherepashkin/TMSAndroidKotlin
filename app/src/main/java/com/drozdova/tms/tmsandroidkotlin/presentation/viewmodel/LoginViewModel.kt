package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.drozdova.tms.tmsandroidkotlin.data.repository.LoginRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val interactor = LoginInteractor(LoginRepositoryImpl(getApplication()))

    fun setName(name: String) {
        interactor.saveLogin(name)
    }
}