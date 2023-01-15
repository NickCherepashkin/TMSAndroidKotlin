package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): ViewModel() {
    private val _isExist = MutableLiveData<Int>()
    val isExist: LiveData<Int> = _isExist

    fun checkUserExists() {
        viewModelScope.launch {
            try {
                val doewUserExist = loginInteractor.checkUserExists()
                _isExist.value = when(doewUserExist) {
                    true -> R.navigation.main_graph
                    false -> R.navigation.auth_graph
                }
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_CHECK_USER_EXISTS} $e")
            }
        }
    }
}