package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

interface HomeView {
    fun showUserCreds(login : String)
    fun goToOnBoarding(destination: Int)
}