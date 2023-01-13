package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

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
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav : LiveData<Int?> = _nav

    fun logoutUser() {
        viewModelScope.launch {
            authInteractor.logoutUser()
            _nav.value = R.navigation.auth_graph
        }
    }

    

}