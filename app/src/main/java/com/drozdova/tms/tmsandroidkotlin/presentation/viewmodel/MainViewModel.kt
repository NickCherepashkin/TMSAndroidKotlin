package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {
    private val _userExist = MutableLiveData<Int>()
    val userExist : LiveData<Int> = _userExist

    fun userIsexist() {
        viewModelScope.launch {
            val doewUserExist = authInteractor.checkUserExists()
            _userExist.value = when(doewUserExist) {
                true -> R.navigation.main_graph
                false -> R.navigation.auth_graph
            }
        }
    }
}