package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.R

class OnBoardingViewModel : ViewModel() {
    private val _btnShowList = MutableLiveData<navToItems?>()
    val btnShowList: LiveData<navToItems?> = _btnShowList

    val onBoardingText = MutableLiveData<String>()

    fun onBtnClick() {
        _btnShowList.value = navToItems(R.id.action_onBoardingFragment_to_itemsFragment, R.id.onBoardingFragment)
    }

    fun onBoardingBack() {
        _btnShowList.value = null
    }
}

data class navToItems (
    val destinationId: Int,
    val fragmentTRemovw: Int
)