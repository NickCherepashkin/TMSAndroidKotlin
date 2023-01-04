package com.drozdova.tms.tmsandroidkotlin.domain.onboarding

import javax.inject.Inject

class OnBoardingInteractor @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) {
    fun saveVisibility(visibility: Boolean) {
        onBoardingRepository.saveVisibility(visibility)
    }

    fun isVisible() : Boolean {
        return onBoardingRepository.isVisible()
    }
}