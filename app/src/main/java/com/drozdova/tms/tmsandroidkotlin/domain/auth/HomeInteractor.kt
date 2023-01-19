package com.drozdova.tms.tmsandroidkotlin.domain.auth

import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val homeRepository: HomeRepository
)  {
    fun getUserCreds() : String{
        return homeRepository.showUserCreds()
    }

    fun showOnBoarding() : Boolean {
        return homeRepository.showOnBoarding()
    }
}