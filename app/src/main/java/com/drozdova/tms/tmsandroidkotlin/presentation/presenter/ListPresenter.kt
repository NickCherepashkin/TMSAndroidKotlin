package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListPresenter @Inject constructor(
    private val listInteractor: ListInteractor
) {

    private lateinit var listView: ListView

    fun setView(listView: ListView) {
        this.listView = listView
    }

    fun getData() {
        val list = listInteractor.getData()
        listView.setData(list)
    }
}