package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.content.Context
import androidx.navigation.NavDestination
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User

interface ListView {
    fun setData(list: List<User>)
    fun goToDetails(name: String, date: String, imageView: Int, destination: Int)
    fun showErrorMessage(context: Context, message: String)
}