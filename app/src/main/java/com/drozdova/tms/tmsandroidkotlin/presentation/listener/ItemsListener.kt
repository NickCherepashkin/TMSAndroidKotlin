package com.drozdova.tms.tmsandroidkotlin.presentation.listener

interface ItemsListener {
    fun onFavClicked(id: Int)
    fun showItemDetails(name: String, date: String, imageView: Int)
    fun findFav(id: Int) : Boolean
    fun deleteItem(id: Int)
}