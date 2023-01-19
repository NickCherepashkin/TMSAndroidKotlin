package com.drozdova.tms.tmsandroidkotlin.presentation.view.listener

interface ItemListener {
    fun itemDetailsClick(description: String, image: String)

    fun imageClick()
}