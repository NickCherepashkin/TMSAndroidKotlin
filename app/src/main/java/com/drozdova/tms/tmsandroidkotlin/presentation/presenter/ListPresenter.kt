package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class   ListPresenter @Inject constructor(
    private val listInteractor: ItemsListInteractor
) {

    private lateinit var listView: ListView

    fun setView(listView: ListView) {
        this.listView = listView
    }

    fun getData(context: Context) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                listInteractor.getData()
                val list = listInteractor.showData()
                listView.setData(list)
            } catch (e: Exception) {
                listView.showErrorMessage(context, ErrorMessages.ERROR_MSG_NO_DATA)
            }
        }
    }

    fun goToDetails(name: String, date: String, imageView: Int) {
        listView.goToDetails(name, date, imageView, R.id.action_itemsListFragment_to_detailsFragment)
    }

    fun onFavClicked(id: Int) {
        CoroutineScope(Dispatchers.IO).launch{
            listInteractor.onFavClicked(id)
        }
    }
}