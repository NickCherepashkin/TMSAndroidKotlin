package com.drozdova.tms.tmsandroidkotlin.presentation.view

import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

interface ItemsView {

    fun dataReceived(listItems: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}