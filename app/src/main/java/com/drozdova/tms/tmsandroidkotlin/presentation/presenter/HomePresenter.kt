package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var homeView: HomeView

    fun setHomeView(homeFragment: HomeFragment) {
        homeView = homeFragment
    }

    fun showUserCreds() {
        val userModel = authInteractor.getUserCreads()
        homeView.showUserCreds(userModel)
    }

    fun goToOnBoarding() {
        homeView.goToOnBoarding()
    }
}