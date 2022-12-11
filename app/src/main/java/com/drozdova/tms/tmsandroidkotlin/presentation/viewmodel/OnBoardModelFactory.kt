package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.domain.OnBoardingInteractor

class OnBoardModelFactory(private val interactor: OnBoardingInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OnBoardingViewModel(interactor) as T
    }
}