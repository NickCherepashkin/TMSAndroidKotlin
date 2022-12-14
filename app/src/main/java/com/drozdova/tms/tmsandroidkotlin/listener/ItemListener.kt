package com.drozdova.tms.tmsandroidkotlin.listener

interface ItemListener {
    fun itemDetailsClick(name: String, date: String, imageView: Int)

    fun imageClick()
}