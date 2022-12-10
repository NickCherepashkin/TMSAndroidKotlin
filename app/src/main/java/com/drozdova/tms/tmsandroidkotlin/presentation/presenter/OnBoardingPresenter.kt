package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor

class OnBoardingPresenter (
    private val onBoardingView: OnBoardingView,
    private val loginInteractor: LoginInteractor
) {
    fun setName(){
        val name = loginInteractor.getLogin()
        onBoardingView.setName(name)
    }
}