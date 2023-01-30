package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.view.View
import androidx.navigation.NavDestination
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import javax.inject.Inject

class MainPresenter@Inject constructor(
    private val loginInteractor: LoginInteractor
) {
    private lateinit var mainView: MainView

    fun setMainView (mainView: MainView) {
        this.mainView = mainView
    }

    fun setStartScreen() {
        val isExist = loginInteractor.checkUserExists()
        val startDest = when(isExist) {
            true -> R.navigation.main_graph
            false -> R.navigation.auth_graph
        }
        mainView.setStartScreen(startDest)
    }

}