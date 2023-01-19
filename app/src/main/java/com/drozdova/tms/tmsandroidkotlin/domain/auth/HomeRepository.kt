package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface HomeRepository {
    fun showUserCreds() : String
    fun showOnBoarding() : Boolean
}