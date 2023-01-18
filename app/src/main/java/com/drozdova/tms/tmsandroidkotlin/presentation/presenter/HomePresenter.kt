package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
){
    private lateinit var homeView: HomeView

    fun setHomeView(homeView: HomeView) {
        this.homeView = homeView
    }

    fun showUserCreds() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val name = loginInteractor.getUserCreds()
                homeView.showUserCreds(name)
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_GET_USER_CREDS} $e")
            }
        }

    }

    fun goToOnBoarding() {
        homeView.goToOnBoarding(R.navigation.main_graph)
    }
}