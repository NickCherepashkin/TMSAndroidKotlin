package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.MainActivity
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
){
    private lateinit var mainView : MainView

    fun setMainView(mainActivity: MainActivity) {
        this.mainView = mainActivity
    }

    fun userIsExist() {
        val doesUserExist = authInteractor.checkUserExists()
        mainView.userIsExist(doesUserExist)
    }
}