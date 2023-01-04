package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun loginUser(login: String, password: String) {
        loginInteractor.saveLogin(login, password)
        _nav.value = Unit
    }
}