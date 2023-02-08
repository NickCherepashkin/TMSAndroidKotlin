package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritePresenter @Inject constructor(
    private val listInteractor: ItemsListInteractor
) {
    private lateinit var favView: FavouriteView

    fun setView(favView: FavouriteView) {
        this.favView = favView
    }

    fun getFavourites() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val list = listInteractor.showFavData()
                favView.setData(list)
            } catch (e: Exception) {
                Log.w("ERRROR", e.toString())
            }
        }
    }

    fun deleteFavItem(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                listInteractor.deleteFavItem(id)
            } catch (e: Exception) {
                Log.w("FAV ERROR", e.toString())
            }
        }
    }
}