package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor,
    private val onBoardingInteractor: OnBoardingInteractor
): ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

//    private val _nav = MutableLiveData<Unit?>()
//    val nav: LiveData<Unit?> = _nav

    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> = _visibility

    fun showUserCreds() {
        viewModelScope.launch {
            try {
                launch {
                    _name.value = loginInteractor.getUserCreds()
                }
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_GET_USER_CREDS} $e")
            }
        }

    }

    fun goToOnBoarding() {
        viewModelScope.launch {
            try {
                _visibility.value = onBoardingInteractor.isVisible()
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_IS_VISIBLE} $e")
            }

        }

    }
}