package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {
    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds : LiveData<UserModel> = _userCreds

    private val _nav = MutableLiveData<Int?>()
    val nav : LiveData<Int?> = _nav

    fun showUserData() {
        viewModelScope.launch {
            _userCreds.value = authInteractor.getUserCreads()
        }
    }

    fun navToOnBoarding() {
        _nav.value = R.navigation.main_graph
    }
}