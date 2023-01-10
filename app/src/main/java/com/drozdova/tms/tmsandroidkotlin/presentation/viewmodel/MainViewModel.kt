package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {
    private val _userExist = MutableLiveData<Boolean>()
    val userExist : LiveData<Boolean> = _userExist

    fun userIsexist() {
        viewModelScope.launch {
            _userExist.value = authInteractor.checkUserExists()
        }
    }
}