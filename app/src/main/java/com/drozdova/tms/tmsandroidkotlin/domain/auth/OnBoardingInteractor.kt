package com.drozdova.tms.tmsandroidkotlin.domain.auth

import javax.inject.Inject

class OnBoardingInteractor @Inject constructor (private val onBoardingRepository: OnBoardingRepository){
    fun saveVisibility(doesVivible: Boolean) {
        onBoardingRepository.saveVisibility(doesVivible)
    }
}