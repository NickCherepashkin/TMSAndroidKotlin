package com.drozdova.tms.tmsandroidkotlin.presentation.listener

interface ItemsListener {
    fun isItemSelected(isSelected: Boolean)
    fun showItemDetails(name: String, date: String, imageView: Int)
}