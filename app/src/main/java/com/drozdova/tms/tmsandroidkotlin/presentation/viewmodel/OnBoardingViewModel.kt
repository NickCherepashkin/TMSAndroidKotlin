package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.OnBoardingInteractor

class OnBoardingViewModel(private val interactor: OnBoardingInteractor) : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    fun getName(){
        _name.value = interactor.getName()
    }
}