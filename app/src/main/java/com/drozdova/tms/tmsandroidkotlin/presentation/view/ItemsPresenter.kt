package com.drozdova.tms.tmsandroidkotlin.presentation.view

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsIterator: ItemsInteractor
) {

    fun getData() {
        val list = itemsIterator.getData()
        itemsView.dataReceived(list)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.hello_blank_fragment)
    }

    fun elementSelected(name: String, date: String, imageView: Int) {
        itemsView.goToDetails(name, date, imageView)
    }
}