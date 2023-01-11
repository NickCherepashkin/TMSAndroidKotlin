package com.drozdova.tms.tmsandroidkotlin.domain.onboarding

import javax.inject.Inject

class OnBoardingInteractor @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) {
    suspend fun saveVisibility(visibility: Boolean) {
        onBoardingRepository.saveVisibility(visibility)
    }

    suspend fun isVisible() : Boolean {
        return onBoardingRepository.isVisible()
    }
}