package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
){
    private lateinit var detailsView: DetailsView

    fun setDetailsView(detailsView: DetailsView) {
        this.detailsView = detailsView
    }

    fun logout() {
        loginInteractor.logout()
        detailsView.logout()
    }
}