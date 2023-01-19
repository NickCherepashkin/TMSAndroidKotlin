package com.drozdova.tms.tmsandroidkotlin.data.auth

import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : HomeRepository {
    override fun showUserCreds() : String{
        return sharedPreferencesHelper.getUserCreds()
//        return withContext(Dispatchers.IO){
//            sharedPreferencesHelper.getUserCreds()
//        }
    }

    override fun showOnBoarding(): Boolean {
        return sharedPreferencesHelper.isVisibleOnBoarding()
    }
}