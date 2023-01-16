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
class DetailsViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Int?>()
    val nav : LiveData<Int?> = _nav

    fun logoutUser() {
        viewModelScope.launch {
            try {
                launch {
                    loginInteractor.logout()
                    _nav.value = R.navigation.auth_graph
                }
            } catch (e: java.lang.Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_LOGOUT} $e")
            }
        }
    }
}