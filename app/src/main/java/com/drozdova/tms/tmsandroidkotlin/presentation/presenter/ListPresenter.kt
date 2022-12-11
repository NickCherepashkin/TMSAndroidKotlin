package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor

class ListPresenter(private val listView: ListView,
private val listInteractor: ListInteractor
) {
    fun getData() {
        val list = listInteractor.getData()
        listView.setData(list)
    }
}