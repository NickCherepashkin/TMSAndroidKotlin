package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): ViewModel() {
    private val _isExist = MutableLiveData<Boolean>()
    val isExist: LiveData<Boolean> = _isExist

    fun checkUserExists() {
        _isExist.value = loginInteractor.checkUserExists()
    }
}