package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
){
    private lateinit var detailsView: DetailsView

    fun setDetailsView(detailsView: DetailsView) {
        this.detailsView = detailsView
    }

    fun logout() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                loginInteractor.logout()
                detailsView.logout(R.navigation.auth_graph)
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_LOGOUT} $e")
            }
        }
    }
}