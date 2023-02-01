package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.content.Context
import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import kotlinx.coroutines.*
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
        val exHendler = CoroutineExceptionHandler { _, exception ->
            Log.w("ERR", exception)
        }
        CoroutineScope(Dispatchers.Main + exHendler).launch {
            CoroutineScope(Dispatchers.Main).launch {
//                listInteractor.getData()
                try {
                    listInteractor.getData()
                } catch (e: Exception) {
                    listView.showErrorMessage(context, e.message.toString())
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    listInteractor.showData().collect{list ->
                        listView.setData(list)
                    }
                } catch (e: Exception) {
                    listView.showErrorMessage(context, "show")
                }
            }
        }
    }

    fun goToDetails(name: String, date: String, imageView: Int) {
        listView.goToDetails(name, date, imageView, R.id.action_itemsListFragment_to_detailsFragment)
    }

    fun onFavClicked(id: Int){
        CoroutineScope(Dispatchers.IO).launch{
            listInteractor.onFavClicked(id)
        }
    }

    fun deleteItem(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            listInteractor.deleteItem(id)
        }
    }

    fun findFav(id: Int) : Boolean {
        return true
//        return CoroutineScope(Dispatchers.IO).async {
//            true
//        }
    }
}