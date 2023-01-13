package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {
    private val _nav = MutableLiveData<Int?>()
    val nav : LiveData<Int?> = _nav

    fun loginUser(userName: String, userPassword: String) {
        val coroutineHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler", "LoginUser FAILED")
        }
        viewModelScope.launch(coroutineHandler) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _nav.value = R.id.action_loginFragment_to_homeFragment
                }

            } catch (e: java.lang.Exception) {
                Log.w("exception", "LoginUser FAILED")
            }

        }
    }

    fun userNavigated() {
        _nav.value = null
    }
}