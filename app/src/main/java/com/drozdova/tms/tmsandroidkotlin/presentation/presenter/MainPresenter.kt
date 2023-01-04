package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import javax.inject.Inject

class MainPresenter@Inject constructor(
    private val loginInteractor: LoginInteractor
) {
    private lateinit var mainView: MainView

    fun setMainView (mainView: MainView) {
        this.mainView = mainView
    }
    fun checkUserExists() {
        val isExist = loginInteractor.checkUserExists()
        mainView.checkUserExists(isExist)
    }
}