package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginPresenter @Inject constructor(
    private val loginInteractor: LoginInteractor
) {
    private lateinit var loginView: LoginView

    fun setLoginView(loginView : LoginView) {
        this.loginView = loginView
    }

    fun loginPresent(login: String, password: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                launch {
                    loginInteractor.saveLogin(login, password)
                    loginView.login()
                }
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_SAVE_LOGIN} $e")
            }
        }

    }


}