package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
){
    private lateinit var homeView: HomeView

    fun setHomeView(homeView: HomeView) {
        this.homeView = homeView
    }

    fun showUserCreds() {
        val name = loginInteractor.getUserCreds()
        homeView.showUserCreds(name)
    }

    fun goToOnBoarding() {
        homeView.goToOnBoarding()
    }
}