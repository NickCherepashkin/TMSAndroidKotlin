package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _msgError = MutableLiveData<String>()
    val msgError: LiveData<String> = _msgError

    fun loginUser(login: String, password: String) {
        viewModelScope.launch {
            try {
                loginInteractor.saveLogin(login, password)
                _nav.value = Unit
            } catch (e: Exception) {
                _msgError.value = ErrorMessages.ERROR_MSG_SAVE_LOGIN
            }
        }
    }
}