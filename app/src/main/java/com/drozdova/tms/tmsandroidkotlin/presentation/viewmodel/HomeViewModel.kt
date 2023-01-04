package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
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
        _name.value = loginInteractor.getUserCreds()
    }

    fun goToOnBoarding() {
        _visibility.value = onBoardingInteractor.isVisible()
    }
}