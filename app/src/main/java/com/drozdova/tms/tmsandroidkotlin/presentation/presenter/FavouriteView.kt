package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User

interface FavouriteView {
    fun setData(list: List<FavUser>)
}