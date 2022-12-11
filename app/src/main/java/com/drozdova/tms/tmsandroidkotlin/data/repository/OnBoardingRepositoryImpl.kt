package com.drozdova.tms.tmsandroidkotlin.data.repository

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.domain.repository.OnBoardingRepository
import com.drozdova.tms.tmsandroidkotlin.utils.SharedPrefConstants

class OnBoardingRepositoryImpl(context: Context) : OnBoardingRepository {
    private val file = context.getSharedPreferences(SharedPrefConstants.SHARED_PREFS_FILE, Context.MODE_PRIVATE)

    override fun getName() : String{
        return file.getString(SharedPrefConstants.KEY_NAME, "") ?: ""
    }
}