package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel : ViewModel() {
    private val _btnShowList = MutableLiveData<Unit?>()
    val btnShowList: LiveData<Unit?> = _btnShowList

    val onBoardingText = MutableLiveData<String>()

    fun onBtnClick() {
        _btnShowList.value = Unit
    }

    fun onBoardingBack() {
        _btnShowList.value = null
    }
}