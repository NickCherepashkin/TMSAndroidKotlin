package com.drozdova.tms.tmsandroidkotlin.data.items

import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : OnBoardingRepository {
    override fun saveVisibility(doesVisible: Boolean) {
        sharedPreferencesHelper.setVisibilityOnBoarding(doesVisible)
    }
}