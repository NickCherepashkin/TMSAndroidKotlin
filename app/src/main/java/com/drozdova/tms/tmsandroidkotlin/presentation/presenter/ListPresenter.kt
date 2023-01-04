package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListPresenter @Inject constructor(
    private val listInteractor: ItemsListInteractor
) {

    private lateinit var listView: ListView

    fun setView(listView: ListView) {
        this.listView = listView
    }

    fun getData() {
        val list = listInteractor.getData()
        listView.setData(list)
    }

    fun goToDetails(name: String, date: String, imageView: Int) {
        listView.goToDetails(name, date, imageView)
    }
}