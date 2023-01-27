package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    suspend fun getData(){
        itemsRepository.getData()
    }

    suspend fun showData(): List<Item> {
        return itemsRepository.showData()
    }

    suspend fun deleteItemByDescription(description: String) {
        itemsRepository.deleteItemByDescription(description)
    }

    suspend fun findItem(searchText: String): Item{
        return itemsRepository.findItemByDescription(searchText)
    }

    suspend fun onFavClicked(description: String) {
        itemsRepository.favClicked(description)
    }

    suspend fun getFav() : List<FavouriteModel>{
        return itemsRepository.getFavourite()
    }
}