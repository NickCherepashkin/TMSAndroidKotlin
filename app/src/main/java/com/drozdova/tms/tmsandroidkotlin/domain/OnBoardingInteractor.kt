package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.domain.repository.OnBoardingRepository

class OnBoardingInteractor (private val onBoardingRepository: OnBoardingRepository) {
    fun getName() : String{
        return onBoardingRepository.getName()
    }
}