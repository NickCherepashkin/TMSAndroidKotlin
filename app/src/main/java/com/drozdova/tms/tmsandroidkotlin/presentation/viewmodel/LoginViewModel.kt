package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    val userCreats = MutableLiveData<String>()

    fun showCreats() {
        userCreats.value = "${userName.value.toString()} \n${userPassword.value.toString()}"
    }
}