package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.model.UserModel

interface HomeView {
    fun showUserCreds(userModel: UserModel)
    fun goToOnBoarding()
}