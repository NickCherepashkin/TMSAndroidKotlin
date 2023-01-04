package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item

interface ListView {
    fun setData(list: List<Item>)
    fun goToDetails(name: String, date: String, imageView: Int)
}