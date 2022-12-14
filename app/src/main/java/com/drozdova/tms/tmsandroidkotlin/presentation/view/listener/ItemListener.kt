package com.drozdova.tms.tmsandroidkotlin.presentation.view.listener

interface ItemListener {
    fun itemDetailsClick(name: String, date: String, imageView: Int)

    fun imageClick()
}