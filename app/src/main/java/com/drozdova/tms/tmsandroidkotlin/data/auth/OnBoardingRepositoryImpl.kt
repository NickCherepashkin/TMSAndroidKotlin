package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : OnBoardingRepository {


    override fun isVisible(): Boolean {
        return sharedPreferencesHelper.isVisibleOnBoarding()
    }

    override fun saveVisibility(visibility: Boolean) {
        sharedPreferencesHelper.setVisibilityOnBoarding(visibility)
    }
}